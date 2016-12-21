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

import com.wondertek.mobilevideo.core.recommend.cache.redis.commons.BinaryJedisClusterFactory;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.TopRecommendCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.model.TopRecommend;
import com.wondertek.mobilevideo.core.recommend.service.TopRecommendService;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendTopVo;

import redis.clients.jedis.BinaryJedisCluster;

public class TopRecommendCacheClusterManagerImpl implements TopRecommendCacheClusterManager {
	private TopRecommendService topRecommendService;
	protected static Boolean cacheAvailable = true;
	private BinaryJedisClusterFactory jedisClusterFactory; //jedis 集群工厂
	
	private Log log = LogFactory.getLog(this.getClass());
	public static Object obj = new Object();
	private static final String RC_PERFIX_KEY = "RI:CLUSTER:TOPRI:";	
	private static MessagePack msgpack = null;
	private int expireTime = 60 * 60 * 1;// 24个小时

	public TopRecommendCacheClusterManagerImpl() {
	}
	static { 
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(RecommendTopVo.class);
		}
	}
	private String getRecomdRedisKey(String prdType) {
		return prdType;
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
	 * 将单个对象序列化为ByteArray
	 * 
	 * @param VomsRecommendVo
	 * @return
	 */
	@SuppressWarnings("unused")
	private byte[] changeValueToByteArray(RecommendTopVo recommendTopVo){
		byte[] valueBytes = null;
		try {
			valueBytes = msgpack.write(recommendTopVo);
		} catch (Exception e) {
			log.error("change value to bytes failed.error info:" + e);
		}
		return valueBytes;
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
		BinaryJedisCluster jedisCluster = null;
		try{
			jedisCluster = jedisClusterFactory.getObject();
		}catch(Exception e){
			log.error("redis getObject failed.error info:" + e);
		}
        List<RecommendTopVo> returnList = null;       
        if (jedisCluster != null) {//redis为空，从数据库中获取
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
        records = jedisCluster.zrange(keyBytes, 0, -1);
        
        if(records == null || records.size() == 0){//为空
        	//查询数据库，若数据库还为空，则存储个空对象进去
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
        	
        	jedisCluster.zadd(keyBytes, 1, changeObjectsToByteArray(tmp));
        	
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
	        	log.debug("queried result from redis successfully!prdType:" + prdType + ",size:" + (tmp == null ? null : tmp.size()));
	        jedisCluster.expire(keyBytes,expireTime);//设置过期时间
        }             
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
		if (cacheAvailable == false) {
			return;
		}
		BinaryJedisCluster jedisCluster = null;
		try {
			jedisCluster = jedisClusterFactory.getObject();
		} catch (Exception e) {
			log.error("redis getObject failed.error info:" + e);
		}
		if (jedisCluster == null) {
			return;
		}
		synchronized (obj) {
			log.debug("updataCache start");
			cacheAvailable = false;
			List<TopRecommend> list = topRecommendService.queryAllAvailable();
			log.debug("updateCache list size:" + list.size());
			
			Map<String, List<RecommendTopVo>> RecommendTopMap = new HashMap<String, List<RecommendTopVo>>();
			// 得到具有相同prdType的RecommendTopVo 的map集合
			if (list != null && !list.isEmpty()) {
				for (TopRecommend tr : list) {
					RecommendTopVo recommendTopVo = new RecommendTopVo();					
					recommendTopVo.setTopId(tr.getTopId());
					}
			}
			List<String> labels = new ArrayList<String>();
			String key = null;
			for (String prdType : RecommendTopMap.keySet()) {
				labels.add(prdType);
				key = RC_PERFIX_KEY + prdType;
				byte[] keyBytes = changeKeyToByteArray(key);
				jedisCluster.del(keyBytes);
				jedisCluster.zadd(keyBytes, 1, changeObjectsToByteArray(RecommendTopMap.get(prdType)));
				jedisCluster.expire(keyBytes, expireTime);
				log.debug("updateCache end,labels size:" + labels.size());
			}
			
			RecommendTopMap.clear();
			RecommendTopMap = null;
			
			cacheAvailable = true;
		}		
	}
	public TopRecommendService getTopRecommendService() {
		return topRecommendService;
	}
	public void setTopRecommendService(TopRecommendService topRecommendService) {
		this.topRecommendService = topRecommendService;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	public BinaryJedisClusterFactory getJedisClusterFactory() {
		return jedisClusterFactory;
	}
	public void setJedisClusterFactory(BinaryJedisClusterFactory jedisClusterFactory) {
		this.jedisClusterFactory = jedisClusterFactory;
	}	
}
