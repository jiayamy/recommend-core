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
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.VomsRecommendCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.service.VomsRecommendService;
import com.wondertek.mobilevideo.core.recommend.util.RecommendConstants;
import com.wondertek.mobilevideo.core.recommend.vo.VomsRecommendVo;
import com.wondertek.mobilevideo.core.util.StringUtil;

import redis.clients.jedis.BinaryJedisCluster;

public class VomsRecommendCacheClusterManagerImpl implements VomsRecommendCacheClusterManager {
	private VomsRecommendService vomsRecommendService;
	protected static Boolean cacheAvailable = true;
	private BinaryJedisClusterFactory jedisClusterFactory; //jedis 集群工厂
	
	private Log log = LogFactory.getLog(this.getClass());
	public static Object obj = new Object();
	private static final String RC_PERFIX_KEY = "RI:CLUSTER:VOMSRI:";
	private static final String RC_KEY_KEY = "RI:CLUSTER:VOMSRIKEY:KEY";
	private static MessagePack msgpack = null;
	private int expireTime = 60 * 60 * 1;// 24个小时

	public VomsRecommendCacheClusterManagerImpl() {
	}
	static { 
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(VomsRecommendVo.class);
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
	 * @param VomsRecommendVo
	 * @return
	 */
	private byte[] changeValueToByteArray(VomsRecommendVo vomsRecommendVo) {
		byte[] valueBytes = null;
		try {
			valueBytes = msgpack.write(vomsRecommendVo);
		} catch (Exception e) {
			log.error("change value to bytes failed.error info:" + e);
		}
		return valueBytes;
	}

	/**
	 * 将对象集合序列化为ByteArray
	 */
	public byte[] changeObjectsToByteArray(List<VomsRecommendVo> vomsRecommendVos) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Packer packer = msgpack.createPacker(out);
			for (VomsRecommendVo vomsRecommendVo : vomsRecommendVos) {
				packer.write(vomsRecommendVo);
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

	private VomsRecommendVo changeByteArrayToVal(byte[] bytes) {
		try {
			VomsRecommendVo vomsRecommendVo = msgpack.read(bytes, VomsRecommendVo.class);
			return vomsRecommendVo;
		} catch (Exception e) {
			log.error("change bytes to star failed.error info:" + e);
		}
		return null;
	}

	/**
	 * 将ByteArray反序列化为对象集合
	 *
	 */
	public List<VomsRecommendVo> changeByteArrayToObjects(byte[] bytes) {
		List<VomsRecommendVo> list = new ArrayList<VomsRecommendVo>();
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			Unpacker unpacker = msgpack.createUnpacker(in);
			VomsRecommendVo vomsRecommendVo = null;
			do {
				vomsRecommendVo = unpacker.read(VomsRecommendVo.class);
				if (vomsRecommendVo != null) {
					list.add(vomsRecommendVo);
				}
			} while (vomsRecommendVo != null);
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

	private List<String> getAllLabelKeys(BinaryJedisCluster jedisCluster) {
		Set<byte[]> records = null;
		String key = RC_KEY_KEY;
		byte[] keyBytes = changeKeyToByteArray(key);
		records = jedisCluster.zrange(keyBytes, 0, -1);
		List<String> tmp = new ArrayList<String>();
		if (records == null || records.size() == 0) {// 为空
			return tmp;
		}
		for (byte[] bytes : records) {
			tmp = changeByteArrayToStrings(bytes);
			break;
		}
		return tmp;
	}

	@Override
	public List<VomsRecommendVo> queryByLabelInfo(List<String> types, String prdType, String labelInfo) {
		BinaryJedisCluster jedisCluster = null;
		try {
			jedisCluster = jedisClusterFactory.getObject();
		} catch (Exception e) {
			log.error("jedisCluster getObject failed.error info:" + e);
		}
		List<VomsRecommendVo> returnList = null;
		if (jedisCluster == null) { // redis为空，从数据库中获取
			returnList = vomsRecommendService.getVomsRecommendVos(types, prdType, labelInfo);
			if (log.isDebugEnabled()) {
				log.debug("queried result from database successfully!labelInfo:" + labelInfo + ",size:" + returnList.size());
			}
			return returnList;
		}
		// 获取标签，如果存在，就查询
		// 所有redis的 key
		List<String> labels = getAllLabelKeys(jedisCluster);
		returnList = new ArrayList<VomsRecommendVo>();

		for (String labelName : labelInfo.split(RecommendConstants.SPLIT_COMMA)) {
			if (StringUtil.isNullStr(labelName) || !labels.contains(getRecomdRedisKey(prdType, labelName))) {
				continue;
			}
			Set<byte[]> recordes = null;
			String key = RC_PERFIX_KEY + getRecomdRedisKey(prdType, labelName);
			byte[] keyBytes = changeKeyToByteArray(key);
			recordes = jedisCluster.zrange(keyBytes, 0, -1);
			if (recordes == null || recordes.size() == 0) {
				// 查询数据库，若数据库还为空，则存储个空对象进去
			} else {
				List<VomsRecommendVo> temp = null;
				for (byte[] bytes : recordes) {
					temp = changeByteArrayToObjects(bytes);
					break;
				}
				if (temp != null) {
					if(types != null && !types.isEmpty()){
						for(VomsRecommendVo vo : temp){
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
					jedisCluster.expire(keyBytes, expireTime);// 设置过期时间
			}

		}

		// 去重
		List<VomsRecommendVo> rst = new ArrayList<VomsRecommendVo>();
		Map<Long, String> contIdMap = new HashMap<Long, String>();
		for (VomsRecommendVo vo : returnList) {
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
			log.debug("updataVomsRecommendCache start");
			cacheAvailable = false;
			List<VomsRecommend> list = vomsRecommendService.getAllRecommend();
			log.debug("updateVomsRecommendCache list size:" + list.size());
			
			Map<String, List<VomsRecommendVo>> vomsRecommendVoMap = new HashMap<String, List<VomsRecommendVo>>();
			// 得到具有相同标签名字的VomsRecommendVo 的map集合
			if (list != null && !list.isEmpty()) {
				for (VomsRecommend v : list) {
					VomsRecommendVo vomsRecommendVo = new VomsRecommendVo();
					vomsRecommendVo.setName(v.getName());
					vomsRecommendVo.setObjId(v.getObjId());
					vomsRecommendVo.setObjType(v.getObjType());
					vomsRecommendVo.setType(v.getType());
					// 获取标签
					for (String labelName : v.getLabelInfo().split(RecommendConstants.SPLIT_COMMA)) {
						if (!StringUtil.isNullStr(labelName)) {
							labelName = getRecomdRedisKey(v.getPrdType(), labelName);
							if (!vomsRecommendVoMap.containsKey(labelName)) {
								vomsRecommendVoMap.put(labelName, new ArrayList<VomsRecommendVo>());
							}
							vomsRecommendVoMap.get(labelName).add(vomsRecommendVo);
						}
					}
				}
			}
			List<String> labels = new ArrayList<String>();
			String key = null;
			for (String labelName : vomsRecommendVoMap.keySet()) {
				labels.add(labelName);
				key = RC_PERFIX_KEY + labelName;
				byte[] keyBytes = changeKeyToByteArray(key);
				jedisCluster.del(keyBytes);
				jedisCluster.zadd(keyBytes, 1, changeObjectsToByteArray(vomsRecommendVoMap.get(labelName)));
				jedisCluster.expire(keyBytes, expireTime);
			}
			key = RC_KEY_KEY;
			byte[] keyBytes = changeKeyToByteArray(key);
			jedisCluster.del(keyBytes);
			jedisCluster.zadd(keyBytes, 1, changeStringsToByteArray(labels));
			jedisCluster.expire(keyBytes, expireTime);
			
			vomsRecommendVoMap.clear();
			vomsRecommendVoMap = null;
			
			cacheAvailable = true;
			log.debug("updateVomsRecommendCache end,labels size:" + labels.size());
		}
	}
	public VomsRecommendService getVomsRecommendService() {
		return vomsRecommendService;
	}
	public void setVomsRecommendService(VomsRecommendService vomsRecommendService) {
		this.vomsRecommendService = vomsRecommendService;
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
