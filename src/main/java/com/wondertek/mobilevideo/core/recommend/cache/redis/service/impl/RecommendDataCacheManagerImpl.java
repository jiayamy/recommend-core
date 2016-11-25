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
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendDataCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendDataCacheManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.service.VomsRecommendService;
import com.wondertek.mobilevideo.core.recommend.util.RecommendConstants;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendDataVo;
import com.wondertek.mobilevideo.core.util.StringUtil;

import redis.clients.jedis.Jedis;

public class RecommendDataCacheManagerImpl implements RecommendDataCacheManager {
	private VomsRecommendService vomsRecommendService;
	protected static Boolean cacheAvailable = true;
	private RedisManager redisManager;

	private Boolean isCluster = Boolean.FALSE;
	private RecommendDataCacheClusterManager recommendDataCacheClusterManager;

	private Log log = LogFactory.getLog(this.getClass());
	public static Object obj = new Object();
	private static final String RC_PERFIX_KEY = "RI:VOMSRI:";
	private static final String RC_KEY_KEY = "RI:VOMSRIKEY:KEY";
	private static MessagePack msgpack = null;
	private int expireTime = 60 * 60 * 1;// 24个小时

	public RecommendDataCacheManagerImpl() {
		
	}

	static {
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(RecommendDataVo.class);
		}
	}

	private String getRecomdRedisKey(String prdType, String labelInfo) {
		return prdType + ":" + labelInfo;
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
	 * @param RecommendDataVo
	 * @return
	 */
	private byte[] changeValueToByteArray(RecommendDataVo recommendDataVo) {
		byte[] valueBytes = null;
		try {
			valueBytes = msgpack.write(recommendDataVo);
		} catch (Exception e) {
			log.error("change value to bytes failed.error info:" + e);
		}
		return valueBytes;
	}

	/**
	 * 将对象集合序列化为ByteArray
	 */
	public byte[] changeObjectsToByteArray(List<RecommendDataVo> recommendDataVos) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Packer packer = msgpack.createPacker(out);
			for (RecommendDataVo recommendDataVo : recommendDataVos) {
				packer.write(recommendDataVo);
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

	private RecommendDataVo changeByteArrayToVal(byte[] bytes) {
		try {
			RecommendDataVo RecommendDataVo = msgpack.read(bytes, RecommendDataVo.class);
			return RecommendDataVo;
		} catch (Exception e) {
			log.error("change bytes to star failed.error info:" + e);
		}
		return null;
	}

	/**
	 * 将ByteArray反序列化为对象集合
	 *
	 */
	public List<RecommendDataVo> changeByteArrayToObjects(byte[] bytes) {
		List<RecommendDataVo> list = new ArrayList<RecommendDataVo>();
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			Unpacker unpacker = msgpack.createUnpacker(in);
			RecommendDataVo recommendDataVo = null;
			do {
				recommendDataVo = unpacker.read(RecommendDataVo.class);
				if (recommendDataVo != null) {
					list.add(recommendDataVo);
				}
			} while (recommendDataVo != null);
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

	private List<String> getAllLabelKeys(Jedis jedis) {
		Set<byte[]> records = null;
		String key = RC_KEY_KEY;
		byte[] keyBytes = changeKeyToByteArray(key);
		records = jedis.zrange(keyBytes, 0, -1);
		if (records == null || records.size() == 0) {// 为空
			return null;
		}
		List<String> tmp = new ArrayList<String>();
		for (byte[] bytes : records) {
			tmp = changeByteArrayToStrings(bytes);
			break;
		}
		return tmp;
	}

	@Override
	public List<RecommendDataVo> queryByLabelInfo(List<String> types, String prdType, String labelInfo) {
		if (isCluster) {
			return recommendDataCacheClusterManager.queryByLabelInfo(types, prdType, labelInfo);
		}
		Jedis jedis = null;
		try {
			jedis = redisManager.getJedis();
		} catch (Exception e) {
			log.error("redis getObject failed.error info:" + e);
		}
		List<RecommendDataVo> returnList = null;
		if (jedis == null) { // redis为空，从数据库中获取
			returnList = vomsRecommendService.getRecommendDataVos(types, prdType, labelInfo);
			if (log.isDebugEnabled()) {
				log.debug("queried result from database successfully!labelInfo:" + labelInfo + ",size:" + returnList.size());
			}
			return returnList;
		}
		// 获取标签，如果存在，就查询
		// 所有redis的 key
		List<String> labels = getAllLabelKeys(jedis);
		returnList = new ArrayList<RecommendDataVo>();

		for (String labelName : labelInfo.split(RecommendConstants.SPLIT_COMMA)) {
			if (StringUtil.isNullStr(labelName) || !labels.contains(getRecomdRedisKey(prdType, labelName))) {
				continue;
			}
			Set<byte[]> recordes = null;
			String key = RC_PERFIX_KEY + getRecomdRedisKey(prdType, labelName);
			byte[] keyBytes = changeKeyToByteArray(key);
			recordes = jedis.zrange(keyBytes, 0, -1);
			if (recordes == null || recordes.size() == 0) {
				// 查询数据库，若数据库还为空，则存储个空对象进去
			} else {
				List<RecommendDataVo> temp = null;
				for (byte[] bytes : recordes) {
					temp = changeByteArrayToObjects(bytes);
					break;
				}
				if (temp != null) {
					if(types != null && !types.isEmpty()){
						for(RecommendDataVo vo : temp){
							if(types.contains(vo.getType())){
								returnList.add(vo);
							}
						}
					}else{
						returnList.addAll(temp);
					}
				}
				if (log.isDebugEnabled()) {
					log.debug("queried result from redis successfully!labelName:" + labelName + ",size:"
							+ (temp == null ? null : temp.size()));
				}
				jedis.expire(keyBytes, expireTime);// 设置过期时间
			}

		}
		redisManager.releaseJedis(jedis);

		// 排序去重
		List<RecommendDataVo> rst = new ArrayList<RecommendDataVo>();
		Map<Long, String> contIdMap = new HashMap<Long, String>();
		for (RecommendDataVo vo : returnList) {
			if (!contIdMap.containsKey(vo.getObjId())) {
				rst.add(vo);
				contIdMap.put(vo.getObjId(), vo.getObjType());
			}
		}
		return rst;
	}
	@Override
	public void updataCache() {
		if (cacheAvailable == false) {
			return;
		}
		if (isCluster) {
			recommendDataCacheClusterManager.updataCache();
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
			log.debug("updataRecommendDataCache start");
			cacheAvailable = false;
			List<VomsRecommend> list = vomsRecommendService.getAllRecommend();
			log.debug("updateRecommendDataCache list size:" + list.size());
			
			Map<String, List<RecommendDataVo>> recommendDataMap = new HashMap<String, List<RecommendDataVo>>();
			// 得到具有相同标签名字的RecommendDataVo 的map集合
			if (list != null && !list.isEmpty()) {
				for (VomsRecommend v : list) {
					RecommendDataVo recommendDataVo = new RecommendDataVo();
					recommendDataVo.setName(v.getName());
					recommendDataVo.setObjId(v.getObjId());
					recommendDataVo.setObjType(v.getObjType());
					recommendDataVo.setType(v.getType());
					// 获取标签
					for (String labelName : v.getLabelInfo().split(RecommendConstants.SPLIT_COMMA)) {
						if (!StringUtil.isNullStr(labelName)) {
							labelName = getRecomdRedisKey(v.getPrdType(), labelName);
							if (!recommendDataMap.containsKey(labelName)) {
								recommendDataMap.put(labelName, new ArrayList<RecommendDataVo>());
							}
							recommendDataMap.get(labelName).add(recommendDataVo);
						}
					}
				}
			}
			List<String> labels = new ArrayList<String>();
			String key = null;
			for (String labelName : recommendDataMap.keySet()) {
				labels.add(labelName);
				key = RC_PERFIX_KEY + labelName;
				byte[] keyBytes = changeKeyToByteArray(key);
				jedis.del(keyBytes);
				jedis.zadd(keyBytes, 1, changeObjectsToByteArray(recommendDataMap.get(labelName)));
				jedis.expire(keyBytes, expireTime);
			}
			key = RC_KEY_KEY;
			byte[] keyBytes = changeKeyToByteArray(key);
			jedis.del(keyBytes);
			jedis.zadd(keyBytes, 1, changeStringsToByteArray(labels));
			jedis.expire(keyBytes, expireTime);
			
			recommendDataMap.clear();
			recommendDataMap = null;
			
			cacheAvailable = true;
			log.debug("updateRecommendDataCache end,labels size:" + labels.size());

		}
		redisManager.releaseJedis(jedis);// 释放连接
	}

	public VomsRecommendService getVomsRecommendService() {
		return vomsRecommendService;
	}
	public void setVomsRecommendService(VomsRecommendService vomsRecommendService) {
		this.vomsRecommendService = vomsRecommendService;
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
	public RecommendDataCacheClusterManager getRecommendDataCacheClusterManager() {
		return recommendDataCacheClusterManager;
	}
	public void setRecommendDataCacheClusterManager(RecommendDataCacheClusterManager recommendDataCacheClusterManager) {
		this.recommendDataCacheClusterManager = recommendDataCacheClusterManager;
	}
	public Boolean getIsCluster() {
		return isCluster;
	}
	public void setIsCluster(Boolean isCluster) {
		this.isCluster = isCluster;
	}
}
