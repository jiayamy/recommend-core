package com.wondertek.mobilevideo.core.recommend.cache.redis.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

import com.wondertek.mobilevideo.core.recommend.cache.redis.commons.RedisManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.TopRecommendCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.TopRecommendCacheManager;
import com.wondertek.mobilevideo.core.recommend.model.TopRecommend;
import com.wondertek.mobilevideo.core.recommend.service.TopRecommendService;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendTopVo;
import com.wondertek.mobilevideo.core.recommend.vo.VomsRecommendVo;

import redis.clients.jedis.Jedis;

public class TopRecommendCacheManagerImpl implements TopRecommendCacheManager {
	private TopRecommendService topRecommendService;
	protected static Boolean cacheAvailable = true;
	private RedisManager redisManager;

	private Boolean isCluster = Boolean.FALSE;
	private TopRecommendCacheClusterManager topRecommendCacheClusterManager;

	private Log log = LogFactory.getLog(this.getClass());
	public static Object obj = new Object();
	private static final String RC_PERFIX_KEY = "RI:TOPRI:";
	private static MessagePack msgpack = null;
	private int expireTime = 60 * 60 * 1;// 24个小时

	public TopRecommendCacheManagerImpl() {
		
	}

	static {
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(VomsRecommendVo.class);
		}
	}

	private String getRecomdRedisKey(String prdType) {
		return  prdType;
	}

	/**
	 * 将KEY序列化为byte
	 * 
	 * @param key
	 * @return
	 */
	private byte[] changeKeyToByteArray(String key) {
		MessagePack msgpack = new MessagePack();
		byte[] keyBytes = null;
		try {
			keyBytes = msgpack.write(key);
		} catch (Exception e) {
			log.error("change key to bytes failed.error info:" + e);
		}
		return keyBytes;
	}	

	/**
	 * 将对象集合序列化为ByteArray
	 */
	public byte[] changeObjectsToByteArray(List<RecommendTopVo> recommendTopVos) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Packer packer = msgpack.createPacker(out);
			for (RecommendTopVo recommendTopVo : recommendTopVos) {
				packer.write(recommendTopVo);
			}
			return out.toByteArray();
		} catch (Exception e) {
			log.error("write val object to byteArray error:" + e);
			return null;
		}
	}

	public byte[] changeStringsToByteArray(List<String> vals) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Packer packer = msgpack.createPacker(out);
			for (String val : vals) {
				packer.write(val);
			}
			return out.toByteArray();
		} catch (Exception e) {
			log.error("write val object to byteArray error:" + e);
			return null;
		}
	}	

	/**
	 * 将ByteArray反序列化为对象集合
	 *
	 */
	public List<RecommendTopVo> changeByteArrayToObjects(byte[] bytes) {
		List<RecommendTopVo> list = new ArrayList<RecommendTopVo>();
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			Unpacker unpacker = msgpack.createUnpacker(in);
			RecommendTopVo recommendTopVo = null;
			do {
				recommendTopVo = unpacker.read(RecommendTopVo.class);
				if (recommendTopVo != null) {
					list.add(recommendTopVo);
				}
			} while (recommendTopVo != null);
			return list;
		} catch (Exception e) {
			log.error("change byteArray to objects error:" + e);
			return list;
		}
	}

	public List<String> changeByteArrayToStrings(byte[] bytes) {
		MessagePack msgpack = new MessagePack();
		List<String> list = new ArrayList<String>();
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			Unpacker unpacker = msgpack.createUnpacker(in);
			String val = null;
			do {
				val = unpacker.read(String.class);
				if (val != null) {
					list.add(val);
				}
			} while (val != null);
			return list;
		} catch (Exception e) {
			log.error("change byteArray to objects error:" + e);
			return list;
		}
	}
	
	@Override
	public List<RecommendTopVo> queryTopVos(String prdType) {
		
		if(isCluster){
			return topRecommendCacheClusterManager.queryTopVos(prdType);
		}
		Jedis jedis = null;
        try {
            jedis = redisManager.getJedis();
        } catch (Exception e) {
            log.error("redis getObject failed.error info:" + e);
        }
        List<RecommendTopVo> returnList = null;
        if (jedis != null) {//redis为空，从数据库中获取
        	List<TopRecommend> list = topRecommendService.queryByParam(prdType);
        	returnList = new ArrayList<RecommendTopVo>();
        	for(TopRecommend topRecommend : list){
        		RecommendTopVo recommendTopVo = new RecommendTopVo();
        		recommendTopVo.setTopId(topRecommend.getTopId());
        		recommendTopVo.setTopName(topRecommend.getTopName());
        		returnList.add(recommendTopVo);
        	}
        	if(log.isDebugEnabled())
        		log.debug("queried result from database successfully!prdType:" + prdType + ",size:" + list.size());
        	list.clear();
        	list = null;
        	return returnList;
        }
        
        returnList = new ArrayList<RecommendTopVo>();       
        Set<byte[]> records = null;
        String key = RC_PERFIX_KEY + getRecomdRedisKey(prdType);
        byte []keyBytes = changeKeyToByteArray(key);
        records = jedis.zrange(keyBytes, 0, -1);
        if(records == null || records.size() == 0){//为空
        	//查询数据库，若数据库还为空，则存储个空对象进去//
        	List<TopRecommend> list = topRecommendService.queryByParam(prdType);
        	List<RecommendTopVo> tmp = new ArrayList<RecommendTopVo>();
        	for(TopRecommend topRecommend : list){
        		RecommendTopVo recommendTopVo = new RecommendTopVo();
        		recommendTopVo.setTopId(topRecommend.getTopId());
        		recommendTopVo.setTopName(topRecommend.getTopName());

        		tmp.add(recommendTopVo);
        	}
        	log.info("add the result queried from database into redis successfully!prdType:" + prdType + ",size:" + list.size());
        	list.clear();
        	list = null;
        	
        	jedis.zadd(keyBytes, 1, changeObjectsToByteArray(tmp));
        	
        	returnList.addAll(tmp);
        }else{
        	List<RecommendTopVo> tmp = null;
	        for (byte[] bytes : records){
	        	tmp = changeByteArrayToObjects(bytes);
	        	break;
	        }
	        if(tmp != null)
	        	returnList.addAll(tmp);
	        if(log.isDebugEnabled())
	        	log.debug("queried result from redis successfully!prdType:" + prdType+ ",size:" + (tmp == null ? null : tmp.size()));
	        jedis.expire(keyBytes,expireTime);//设置过期时间
        }       
        redisManager.releaseJedis(jedis);//释放连接
        
        //排序去重
        List<RecommendTopVo> rst = new ArrayList<RecommendTopVo>();
        Map<Long,Long> contIdMap = new HashMap<Long,Long>();
        for(RecommendTopVo recommendTopVo : returnList){
        	if(!contIdMap.containsKey(recommendTopVo.getTopId())){
        		rst.add(recommendTopVo);
        		contIdMap.put(recommendTopVo.getTopId(), recommendTopVo.getTopId());
        	}
        }
		return rst;
	}
	
	@Override
	public void updataCache() {
		if (cacheAvailable == false) {//正在刷新的暂时不刷新，等待下一次的定时任务启动
			return;
		}
		if (isCluster) {
			topRecommendCacheClusterManager.updataCache();
		}
		Jedis jedis = null;
		try {
			jedis = redisManager.getJedis();
		} catch (Exception e) {
			log.error("redis getObject failed.error info:" + e);
		}

		if (jedis == null) {
			return;
		}
		synchronized (obj) {
			log.debug("updataCache start");
			cacheAvailable = false;
			List<TopRecommend> list = topRecommendService.queryAllAvailable();
			log.debug("updataCache list size:" + list.size());
			
			Map<String, List<RecommendTopVo>> recommendTopVoMap = new HashMap<String, List<RecommendTopVo>>();			
			if (list != null && !list.isEmpty()) {
				for (TopRecommend t : list) {
					RecommendTopVo recommendTopVo = new RecommendTopVo();					
					recommendTopVo.setTopId(t.getTopId());					
				}
			}
			String key = null;
			for (String prdType : recommendTopVoMap.keySet()) {
				key = RC_PERFIX_KEY + prdType;
				byte[] keyBytes = changeKeyToByteArray(key);
				jedis.del(keyBytes);
				jedis.zadd(keyBytes, 1, changeObjectsToByteArray(recommendTopVoMap.get(prdType)));
				jedis.expire(keyBytes, expireTime);
				log.debug("updataCache prdType size:" + recommendTopVoMap.get(prdType).size());
			}
			
			recommendTopVoMap.clear();
			recommendTopVoMap = null;
			
			cacheAvailable = true;
		}
		redisManager.releaseJedis(jedis);// 释放连接
	}

	public TopRecommendService getTopRecommendService() {
		return topRecommendService;
	}
	public void setTopRecommendService(TopRecommendService topRecommendService) {
		this.topRecommendService = topRecommendService;
	}
	public RedisManager getRedisManager() {
		return redisManager;
	}
	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	public Boolean getIsCluster() {
		return isCluster;
	}
	public void setIsCluster(Boolean isCluster) {
		this.isCluster = isCluster;
	}
	public TopRecommendCacheClusterManager getTopRecommendCacheClusterManager() {
		return topRecommendCacheClusterManager;
	}
	public void setTopRecommendCacheClusterManager(TopRecommendCacheClusterManager topRecommendCacheClusterManager) {
		this.topRecommendCacheClusterManager = topRecommendCacheClusterManager;
	}	
}
