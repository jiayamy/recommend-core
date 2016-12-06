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
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendInfoCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendInfoCacheManager;
import com.wondertek.mobilevideo.core.recommend.model.RecommendInfo;
import com.wondertek.mobilevideo.core.recommend.service.RecommendInfoService;
import com.wondertek.mobilevideo.core.recommend.util.RecommendConstants;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendInfoVo;
import com.wondertek.mobilevideo.core.util.StringUtil;

import redis.clients.jedis.Jedis;

/**
 * 推荐信息
 * @author lvliuzhong
 *
 */
public class RecommendInfoCacheManagerImpl implements RecommendInfoCacheManager
{

    public static Object obj = new Object();
    protected static Boolean cacheAvailable = true;	//标记是否正在从数据库中更新stars全量数据到redis中
    private Log log = LogFactory.getLog(this.getClass());
    
    private Boolean isCluster = Boolean.FALSE; 
    private RecommendInfoCacheClusterManager recommendInfoCacheClusterManager;
    
    private RedisManager redisManager;
    
    private RecommendInfoService recommendInfoService;
    private static final String RI_PREFIX_KEY = "RI:RI:";
    private static final String RI_KEY_KEY = "RI:RIKEY:KEY";	//里面的数据是个list，值为 prdType:label
    private int expireTime = 60*60*1;//24个小时
    private static MessagePack msgpack = null;
    
    public RecommendInfoCacheManagerImpl(){}
    static {
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(RecommendInfoVo.class);
		}
	}
    public RedisManager getRedisManager() {
		return redisManager;
	}
	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}
	public RecommendInfoService getRecommendInfoService() {
		return recommendInfoService;
	}
	public void setRecommendInfoService(RecommendInfoService recommendInfoService) {
		this.recommendInfoService = recommendInfoService;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	/**
     * 将KEY序列化为byte
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
     * @param recommendInfoVo
     * @return
     */
	private byte[] changeValueToByteArray(RecommendInfoVo recommendInfoVo) {
        byte[] valueBytes = null;
        try {
            valueBytes = msgpack.write(recommendInfoVo);
        } catch (Exception e) {
            log.error("change value to bytes failed.error info:" + e);
        }
        return valueBytes;
    }
    /**
     * 将对象集合序列化为ByteArray
     * */
    public byte[] changeObjectsToByteArray(List<RecommendInfoVo> recommendInfoVos){
    	try
    	{
    		ByteArrayOutputStream out = new ByteArrayOutputStream();
    		Packer packer = msgpack.createPacker(out);
    		for(RecommendInfoVo recommendInfoVo : recommendInfoVos){
    			packer.write(recommendInfoVo);
    		}
    		return out.toByteArray();
    	}catch (Exception e){
    		log.error("write val object to byteArray error:"+e);
    		return  null;
    	}
    }
    public byte[] changeStringsToByteArray(List<String> vals){
    	try
    	{
    		ByteArrayOutputStream out = new ByteArrayOutputStream();
    		Packer packer = msgpack.createPacker(out);
    		for(String val : vals){
    			packer.write(val);
    		}
    		return out.toByteArray();
    	}catch (Exception e){
    		log.error("write val object to byteArray error:"+e);
    		return  null;
    	}
    }
	private RecommendInfoVo changeByteArrayToVal(byte[] bytes){
        try {
        	RecommendInfoVo recommendInfoVo = msgpack.read(bytes, RecommendInfoVo.class);
            return recommendInfoVo ;
        } catch (Exception e) {
            log.error("change bytes to star failed.error info:" + e);
        }
        return null;
    }
    /**
     * 将ByteArray反序列化为对象集合
     *
     * */
    public List<RecommendInfoVo> changeByteArrayToObjects(byte[] bytes){
        List<RecommendInfoVo> list = new ArrayList<RecommendInfoVo>();
        try
        {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            Unpacker unpacker = msgpack.createUnpacker(in);
            RecommendInfoVo recommendInfoVo = null;
            do{
            	recommendInfoVo = unpacker.read(RecommendInfoVo.class);
                if(recommendInfoVo != null){
                    list.add(recommendInfoVo);
                }
            }while (recommendInfoVo != null);
            return list;
        }catch (Exception e){
            log.error("change byteArray to objects error:"+e);
            return list;
        }
    }
    public List<String> changeByteArrayToStrings(byte[] bytes){
    	MessagePack msgpack = new MessagePack();
        List<String> list = new ArrayList<String>();
        try
        {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            Unpacker unpacker = msgpack.createUnpacker(in);
            String val = null;
            do{
            	val = unpacker.read(String.class);
                if(val != null){
                    list.add(val);
                }
            }while (val != null);
            return list;
        }catch (Exception e){
            log.error("change byteArray to objects error:"+e);
            return list;
        }
    }
    @Override
	public List<RecommendInfoVo> queryByLabel(String labelName, String prdType, String catId) {
    	if(isCluster){
			return recommendInfoCacheClusterManager.queryByLabel(labelName, prdType, catId);
		}
    	Jedis jedis = null;
        try {
            jedis = redisManager.getJedis();
        } catch (Exception e) {
            log.error("redis getObject failed.error info:" + e);
        }
        List<RecommendInfoVo> returnList = null;
        if (jedis == null) {//redis为空，从数据库中获取
        	List<RecommendInfo> list = recommendInfoService.queryByLabels(labelName,prdType, catId);
        	returnList = new ArrayList<RecommendInfoVo>();
        	for(RecommendInfo recommendInfo : list){
        		RecommendInfoVo recommendInfoVo = new RecommendInfoVo();
        		recommendInfoVo.setPrdContId(recommendInfo.getPrdContId());
        		recommendInfoVo.setContName(recommendInfo.getContName());
        		
        		returnList.add(recommendInfoVo);
        	}
        	if(log.isDebugEnabled())
        		log.debug("queried result from database successfully!labelName:" + labelName + ",size:" + list.size());
        	list.clear();
        	list = null;
        	return returnList;
        }
        //获取标签，如果存在就查询
        List<String> labels = getAllLabelKeys(jedis);
        if(!labels.contains(getRecomdRedisKey(prdType, labelName,catId))){
        	return returnList;
        }
        Set<byte[]> records = null;
        String key = RI_PREFIX_KEY + getRecomdRedisKey(prdType, labelName,catId);
        byte []keyBytes = changeKeyToByteArray(key);
        records = jedis.zrange(keyBytes, 0, -1);
        if(records == null || records.size() == 0){//为空
        	//查询数据库，若数据库还为空，则存储个空对象进去
        	
//        	List<RecommendInfo> list = recommendInfoService.queryByLabels(labelName, prdType);
//        	returnList = new ArrayList<RecommendInfoVo>();
//        	for(RecommendInfo recommendInfo : list){
//        		RecommendInfoVo recommendInfoVo = new RecommendInfoVo();
//        		recommendInfoVo.setPrdContId(recommendInfo.getPrdContId());
//        		recommendInfoVo.setContName(recommendInfo.getContName());
//        		
//        		returnList.add(recommendInfoVo);
//        	}
//        	log.info("add the result queried from database into redis successfully!labelName:" + labelName + ",size:" + list.size());
//        	list.clear();
//        	list = null;
//        	
//        	jedis.zadd(keyBytes, 1, changeObjectsToByteArray(returnList));
        }else{
	        for (byte[] bytes : records){
	        	returnList = changeByteArrayToObjects(bytes);
	        	break;
	        }
	        if(log.isDebugEnabled())
	        	log.debug("queried result from redis successfully!labelName:" + labelName + ",size:" + (returnList == null ? null : returnList.size()));
	        jedis.expire(keyBytes,expireTime);//设置过期时间
        }
        redisManager.releaseJedis(jedis);//释放连接
		return returnList;
	}
    
	@Override
	public List<RecommendInfoVo> queryByLabels(String labelNames, String prdType, String catId) {
		if(isCluster){
			return recommendInfoCacheClusterManager.queryByLabel(labelNames, prdType, catId);
		}
		Jedis jedis = null;
        try {
            jedis = redisManager.getJedis();
        } catch (Exception e) {
            log.error("redis getObject failed.error info:" + e);
        }
        List<RecommendInfoVo> returnList = null;
        if (jedis == null) {//redis为空，从数据库中获取
        	List<RecommendInfo> list = recommendInfoService.queryByLabels(labelNames, prdType, catId);
        	returnList = new ArrayList<RecommendInfoVo>();
        	for(RecommendInfo recommendInfo : list){
        		RecommendInfoVo recommendInfoVo = new RecommendInfoVo();
        		recommendInfoVo.setPrdContId(recommendInfo.getPrdContId());
        		recommendInfoVo.setContName(recommendInfo.getContName());
        		
        		returnList.add(recommendInfoVo);
        	}
        	if(log.isDebugEnabled())
        		log.debug("queried result from database successfully!labelName:" + labelNames + ",size:" + list.size());
        	list.clear();
        	list = null;
        	return returnList;
        }
        //一个个标签的查找
        //获取标签，如果存在就查询
        List<String> labels = getAllLabelKeys(jedis);
        
        returnList = new ArrayList<RecommendInfoVo>();
        for(String labelName : labelNames.split(RecommendConstants.SPLIT_COMMA)){
            if(StringUtil.isNullStr(labelName) || !labels.contains(getRecomdRedisKey(prdType,labelName,catId))){
            	continue;
            }
	        Set<byte[]> records = null;
	        String key = RI_PREFIX_KEY + getRecomdRedisKey(prdType,labelName,catId);
	        byte []keyBytes = changeKeyToByteArray(key);
	        records = jedis.zrange(keyBytes, 0, -1);
	        
	        if(records == null || records.size() == 0){//为空
	        	//查询数据库，若数据库还为空，则存储个空对象进去
//	        	List<RecommendInfo> list = recommendInfoService.queryByLabels(labelName, prdType);
//	        	List<RecommendInfoVo> tmp = new ArrayList<RecommendInfoVo>();
//	        	for(RecommendInfo recommendInfo : list){
//	        		RecommendInfoVo recommendInfoVo = new RecommendInfoVo();
//	        		recommendInfoVo.setPrdContId(recommendInfo.getPrdContId());
//	        		recommendInfoVo.setContName(recommendInfo.getContName());
//	        		
//	        		tmp.add(recommendInfoVo);
//	        	}
//	        	log.info("add the result queried from database into redis successfully!labelName:" + labelName + ",size:" + list.size());
//	        	list.clear();
//	        	list = null;
//	        	
//	        	jedis.zadd(keyBytes, 1, changeObjectsToByteArray(tmp));
//	        	
//	        	returnList.addAll(tmp);
	        }else{
	        	List<RecommendInfoVo> tmp = null;
		        for (byte[] bytes : records){
		        	tmp = changeByteArrayToObjects(bytes);
		        	break;
		        }
		        if(tmp != null)
		        	returnList.addAll(tmp);
		        if(log.isDebugEnabled())
		        	log.debug("queried result from redis successfully!labelName:" + labelName + ",size:" + (tmp == null ? null : tmp.size()));
		        jedis.expire(keyBytes,expireTime);//设置过期时间
	        }
        }
        redisManager.releaseJedis(jedis);//释放连接
        
        //排序去重
        List<RecommendInfoVo> rst = new ArrayList<RecommendInfoVo>();
        Map<Long,Long> contIdMap = new HashMap<Long,Long>();
        for(RecommendInfoVo recommendInfoVo : returnList){
        	if(!contIdMap.containsKey(recommendInfoVo.getPrdContId())){
        		rst.add(recommendInfoVo);
        		contIdMap.put(recommendInfoVo.getPrdContId(), recommendInfoVo.getPrdContId());
        	}
        }
		return rst;
	}
	private String getRecomdRedisKey(String prdType, String labelName, String catId) {
		return prdType + ":" + catId + ":" + labelName;
	}
	private List<String> getAllLabelKeys(Jedis jedis){
		Set<byte[]> records = null;
		String key = RI_KEY_KEY;
        byte []keyBytes = changeKeyToByteArray(key);
        records = jedis.zrange(keyBytes, 0, -1);
        if(records == null || records.size() == 0){//为空
        	return null;
        }
        List<String> tmp = new ArrayList<String>();
        for (byte[] bytes : records){
        	tmp = changeByteArrayToStrings(bytes);
        	break;
        }
        return tmp;
	}
    @Override
    public void updateCache(){
    	if(cacheAvailable == false){//正在刷新的暂时不刷新，等待下一次的定时任务启动
    		return;
    	}
    	if(isCluster){
			recommendInfoCacheClusterManager.updateCache();
			return;
		}
        Jedis jedis = null;
        try {
            jedis = redisManager.getJedis();
        } catch (Exception e) {
            log.error("redis getObject failed.error info:" + e);
            return;
        }
        if(jedis == null){
        	return;
        }
        synchronized (obj){
        	log.debug("updateCache start");
            cacheAvailable = false;
            List<RecommendInfo> list = recommendInfoService.queryAllAvailable();
            log.debug("updateCache list size:" + list.size());
            
            Map<String,List<RecommendInfoVo>> vos = new HashMap<String,List<RecommendInfoVo>>();
            if(list != null && !list.isEmpty()){
            	for(RecommendInfo recommendInfo : list){
            		RecommendInfoVo recommendInfoVo = new RecommendInfoVo();
	        		recommendInfoVo.setPrdContId(recommendInfo.getPrdContId());
	        		recommendInfoVo.setContName(recommendInfo.getContName());
	        		
	        		//获取标签
	        		for(String labelName : recommendInfo.getLabelInfo().split(RecommendConstants.SPLIT_COMMA)){
	        			if(!StringUtil.isNullStr(labelName)){
	        				labelName = getRecomdRedisKey(recommendInfo.getPrdType(),labelName,recommendInfo.getCatId());
	        				if(!vos.containsKey(labelName)){
	        					vos.put(labelName, new ArrayList<RecommendInfoVo>());
	        				}
	        				vos.get(labelName).add(recommendInfoVo);
	        			}
	        		}
            	}
            }
            List<String> labels = new ArrayList<String>();
            String key = null;
            for(String labelName : vos.keySet()){
            	labels.add(labelName);
            	key = RI_PREFIX_KEY + labelName;
            	byte []keyBytes = changeKeyToByteArray(key);
            	jedis.del(keyBytes);
            	
            	jedis.zadd(keyBytes, 1, changeObjectsToByteArray(vos.get(labelName)));
            	jedis.expire(keyBytes,expireTime);//设置过期时间
            }
            
            key = RI_KEY_KEY;
            byte []keyBytes = changeKeyToByteArray(key);
            jedis.del(keyBytes);
        	
        	jedis.zadd(keyBytes, 1, changeStringsToByteArray(labels));
        	jedis.expire(keyBytes,expireTime);//设置过期时间
        	
        	vos.clear();
        	vos = null;
			
            cacheAvailable = true;
            log.debug("updateCache end,labels size:" + labels.size());
        }
        redisManager.releaseJedis(jedis);//释放连接
    }
	public RecommendInfoCacheClusterManager getRecommendInfoCacheClusterManager() {
		return recommendInfoCacheClusterManager;
	}
	public void setRecommendInfoCacheClusterManager(RecommendInfoCacheClusterManager recommendInfoCacheClusterManager) {
		this.recommendInfoCacheClusterManager = recommendInfoCacheClusterManager;
	}
	public Boolean getIsCluster() {
		return isCluster;
	}
	public void setIsCluster(Boolean isCluster) {
		this.isCluster = isCluster;
	}
}