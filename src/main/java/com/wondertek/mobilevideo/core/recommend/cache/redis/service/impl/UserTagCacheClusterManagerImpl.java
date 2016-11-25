package com.wondertek.mobilevideo.core.recommend.cache.redis.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

import com.wondertek.mobilevideo.core.recommend.cache.redis.commons.BinaryJedisClusterFactory;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.UserTagCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.mongo.service.UserTagService;
import com.wondertek.mobilevideo.core.recommend.util.CatInfoSort;
import com.wondertek.mobilevideo.core.recommend.util.CatItemSort;
import com.wondertek.mobilevideo.core.recommend.util.RecomdItemSort;
import com.wondertek.mobilevideo.core.recommend.util.RequestConstants;
import com.wondertek.mobilevideo.core.recommend.vo.mongo.CatInfo;
import com.wondertek.mobilevideo.core.recommend.vo.mongo.CatItem;
import com.wondertek.mobilevideo.core.recommend.vo.mongo.RecomdItem;
import com.wondertek.mobilevideo.core.recommend.vo.mongo.UserTag;

import redis.clients.jedis.BinaryJedisCluster;


public class UserTagCacheClusterManagerImpl implements UserTagCacheClusterManager {
	public static Object obj = new Object();
    protected static Boolean cacheAvailable = true;	//标记是否正在从数据库中更新stars全量数据到redis中
    
    private Log log = LogFactory.getLog(this.getClass());
    
    private BinaryJedisClusterFactory jedisClusterFactory;
    
    private UserTagService userTagService;
    
    private static final String UT_PREFIX_KEY = "RI:CLUSTER:USERTAG:";
    private static final String UT_CUT_PREFIX_KEY = "RI:CLUSTER:USERTAG:CUT:";
    
    private int expireTime = 60*3;//3分钟
    private static MessagePack msgpack = null;
    
    public UserTagCacheClusterManagerImpl(){}
    static {
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(UserTag.class);
		}
	}
	public UserTagService getUserTagService() {
		return userTagService;
	}
	public void setUserTagService(UserTagService userTagService) {
		this.userTagService = userTagService;
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
     * @param UserTag
     * @return
     */
    private byte[] changeValueToByteArray(UserTag UserTag) {
        byte[] valueBytes = null;
        try {
            valueBytes = msgpack.write(UserTag);
        } catch (Exception e) {
            log.error("change value to bytes failed.error info:" + e);
        }
        return valueBytes;
    }
    /**
     * 将对象集合序列化为ByteArray
     * */
    public byte[] changeObjectsToByteArray(List<UserTag> UserTags){
    	try
    	{
    		ByteArrayOutputStream out = new ByteArrayOutputStream();
    		Packer packer = msgpack.createPacker(out);
    		for(UserTag UserTag : UserTags){
    			packer.write(UserTag);
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
    private UserTag changeByteArrayToVal(byte[] bytes){
        try {
        	UserTag UserTag = msgpack.read(bytes, UserTag.class);
            return UserTag ;
        } catch (Exception e) {
            log.error("change bytes to star failed.error info:" + e);
        }
        return null;
    }
    /**
     * 将ByteArray反序列化为对象集合
     *
     * */
    public List<UserTag> changeByteArrayToObjects(byte[] bytes){
        List<UserTag> list = new ArrayList<UserTag>();
        try
        {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            Unpacker unpacker = msgpack.createUnpacker(in);
            UserTag UserTag = null;
            do{
            	UserTag = unpacker.read(UserTag.class);
                if(UserTag != null){
                    list.add(UserTag);
                }
            }while (UserTag != null);
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
	public UserTag queryById(String id) {
		BinaryJedisCluster jedisCluster = null;
		try{
			jedisCluster = jedisClusterFactory.getObject();
		}catch(Exception e){
			log.error("redis getObject failed.error info:" + e);
		}
        UserTag userTag = null;
        if (jedisCluster == null) {//redis为空，从数据库中获取
        	com.wondertek.mobilevideo.core.recommend.mongo.model.UserTag mongoUserTag = userTagService.queryById(id);
        	if(mongoUserTag != null){
        		userTag = changeBean(mongoUserTag);
        	}
        	if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
        		log.debug("search from mongodb,userTag:" + userTag);
        	}
        	return userTag;
        }
        //
        String key = UT_PREFIX_KEY + id;
        byte[] keyBytes = changeKeyToByteArray(key);
//        jedis.del(keyBytes);
        userTag = changeByteArrayToVal(jedisCluster.get(keyBytes));
        if(userTag == null){
        	com.wondertek.mobilevideo.core.recommend.mongo.model.UserTag mongoUserTag = userTagService.queryById(id);
        	if(mongoUserTag == null){
        		userTag = new UserTag();
        	}else{
        		userTag = changeBean(mongoUserTag);
        	}
        	if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
        		log.debug("search from mongodb,userTag:" + userTag);
        	}
        		jedisCluster.set(keyBytes, changeValueToByteArray(userTag));
        		jedisCluster.expire(keyBytes, expireTime);
        	
        }else if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
    		log.debug("search from redis,userTag:" + userTag);
    	}
		return userTag;
	}
	@Override
	public UserTag queryCutById(String id) {
		BinaryJedisCluster jedisCluster = null;		
	    try {
	    	jedisCluster = jedisClusterFactory.getObject();
	    } catch (Exception e) {
	            log.error("redis getObject failed.error info:" + e);
	        }
		
        UserTag userTag = null;
        if (jedisCluster == null) {//redis为空，从数据库中获取
        	userTag = this.queryById(id);
        	if(userTag != null){
        		//排序删除方法
        		userTag = fillSortCut(userTag);
        	}
        	if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
        		log.debug("search from mongodb,userTag:" + userTag);
        	}
        	return userTag;
        }
        //
        String key = UT_CUT_PREFIX_KEY + id;
        byte[] keyBytes = changeKeyToByteArray(key);
//        jedis.del(keyBytes);
        userTag = changeByteArrayToVal(jedisCluster.get(keyBytes));
        if(userTag == null){
        	userTag = this.queryById(id);
        	if(userTag == null){
        		userTag = new UserTag();
        	}else{
        		userTag = fillSortCut(userTag);
        	}
        	if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
        		log.debug("search from mongodb,userTag:" + userTag);
        	}
        	
        	jedisCluster.set(keyBytes, changeValueToByteArray(userTag));
        	jedisCluster.expire(keyBytes, expireTime);
        	
        }else if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
    		log.debug("search from redis,userTag:" + userTag);
    	}
		return userTag;
	}
	/**
	 * 填充默认分数，排序，剪切
	 * @param userTag
	 * @return
	 */
	private UserTag fillSortCut(UserTag userTag) {
		Double defaultScore = RequestConstants.V_DEFAULT_USERTAG_SCORE;
		if(userTag.getCats() != null && userTag.getCats().size() > 0){
			int count = 0;
			
			int catMaxCount = RequestConstants.V_DEFAUL_REQUEST_TAG_CAT_MAX;
			int catItemMaxCount = RequestConstants.V_DEFAUL_REQUEST_TAG_CATITEM_MAX;
			int catRecomdMaxCount = RequestConstants.V_DEFAUL_REQUEST_TAG_RECOMD_MAX;
			
			for(CatInfo catInfo : userTag.getCats()){
				//一级分类的分数
				if(catInfo.getScore() == null){
					catInfo.setScore(defaultScore);
				}
				//一级分类下推荐标签分数
				if(catInfo.getRecommendation() != null){
					for(RecomdItem recomdItem : catInfo.getRecommendation()){
						if(recomdItem.getScore() == null){
							recomdItem.setScore(defaultScore);
						}
					}
					//排序，分从高到低
					List<RecomdItem> recommendation = catInfo.getRecommendation();
					Collections.sort(recommendation,new RecomdItemSort());
					catInfo.setRecommendation(recommendation);
					//剪切
					count = 0;
					List<RecomdItem> tmp = new ArrayList<RecomdItem>();
					for(RecomdItem recomdItem : recommendation){
						if(count < catRecomdMaxCount){
							tmp.add(recomdItem);
						}else{
							break;
						}
						count ++;
					}
					catInfo.setRecommendation(tmp);
					
				}
				//一级分类下标签分数
				if(catInfo.getItems() != null){
					for(CatItem catItem : catInfo.getItems()){
						if(catItem.getScore() == null){
							catItem.setScore(defaultScore);
						}
					}
					//一级分类下的标签分数填充完后做一次排序
					List<CatItem> items = catInfo.getItems();
					Collections.sort(items,new CatItemSort());
					catInfo.setItems(items);
					//剪切
					count = 0;
					List<CatItem> tmp = new ArrayList<CatItem>();
					for(CatItem catItem : items){
						if(count < catItemMaxCount){
							tmp.add(catItem);
						}else{
							break;
						}
						count ++;
					}
					catInfo.setItems(tmp);
				}
			}
			//一级分类分数填充完后做一次排序
			List<CatInfo> items = userTag.getCats();
			Collections.sort(items,new CatInfoSort());
			userTag.setCats(items);
			//剪切
			count = 0;
			List<CatInfo> tmp = new ArrayList<CatInfo>();
			for(CatInfo catInfo : userTag.getCats()){
				if(count < catMaxCount){
					tmp.add(catInfo);
				}else{
					break;
				}
				count ++;
			}
			userTag.setCats(tmp);
		}
		return userTag;
	}
    /**
     * 转换2个bean
     * @param mongoUserTag
     * @return
     */
	private UserTag changeBean(com.wondertek.mobilevideo.core.recommend.mongo.model.UserTag mongoUserTag){
		UserTag userTag = new UserTag();
		userTag.setId(mongoUserTag.getId());
		userTag.setCats(mongoUserTag.getCats());
		return userTag;
	}
	public BinaryJedisClusterFactory getJedisClusterFactory() {
		return jedisClusterFactory;
	}
	public void setJedisClusterFactory(BinaryJedisClusterFactory jedisClusterFactory) {
		this.jedisClusterFactory = jedisClusterFactory;
	}
}
