package com.wondertek.mobilevideo.core.recommend.cache.redis.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

import com.wondertek.mobilevideo.core.recommend.cache.redis.commons.RedisManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.UserTagCacheManager;
import com.wondertek.mobilevideo.core.recommend.mongo.service.UserTagService;
import com.wondertek.mobilevideo.core.recommend.util.RequestConstants;
import com.wondertek.mobilevideo.core.recommend.vo.mongo.UserTag;

import redis.clients.jedis.Jedis;

/**
 * 用户标签信息
 * @author lvliuzhong
 *
 */
public class UserTagCacheManagerImpl implements UserTagCacheManager
{

    public static Object obj = new Object();
    protected static Boolean cacheAvailable = true;	//标记是否正在从数据库中更新stars全量数据到redis中
    private Log log = LogFactory.getLog(this.getClass());
    
    private RedisManager redisManager;
    
    private UserTagService userTagService;
    private static final String UT_PREFIX_KEY = "RI:USERTAG:";
    private int expireTime = 60*3;//3分钟
    private static MessagePack msgpack = null;
    
    public UserTagCacheManagerImpl(){}
    static {
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(UserTag.class);
		}
	}
    public RedisManager getRedisManager() {
		return redisManager;
	}
	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
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
		Jedis jedis = null;
        try {
            jedis = redisManager.getJedis();
        } catch (Exception e) {
            log.error("redis getObject failed.error info:" + e);
        }
        UserTag userTag = null;
        if (jedis == null) {//redis为空，从数据库中获取
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
        userTag = changeByteArrayToVal(jedis.get(keyBytes));
        if(userTag == null){
        	com.wondertek.mobilevideo.core.recommend.mongo.model.UserTag mongoUserTag = userTagService.queryById(id);
        	if(log.isDebugEnabled()){
        		log.debug("search from redis");
        	}
        	if(mongoUserTag == null){
        		userTag = new UserTag();
        	}else{
        		userTag = changeBean(mongoUserTag);
        	}
        	if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
        		log.debug("search from mongodb,userTag:" + userTag);
        	}
        	jedis.set(keyBytes, changeValueToByteArray(userTag));
        	jedis.expire(keyBytes, expireTime);
        }else if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
    		log.debug("search from redis,userTag:" + userTag);
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
}
