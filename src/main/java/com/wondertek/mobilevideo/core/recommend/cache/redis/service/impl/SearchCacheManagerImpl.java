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
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.SearchCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.SearchCacheManager;
import com.wondertek.mobilevideo.core.recommend.search.SearchRequest;
import com.wondertek.mobilevideo.core.recommend.search.SearchResult;
import com.wondertek.mobilevideo.core.recommend.search.SearchUtil;

import redis.clients.jedis.Jedis;

/**
 * 用户标签信息
 * @author lvliuzhong
 *
 */
public class SearchCacheManagerImpl implements SearchCacheManager
{

    public static Object obj = new Object();
    protected static Boolean cacheAvailable = true;	//标记是否正在从数据库中更新stars全量数据到redis中
    private Log log = LogFactory.getLog(this.getClass());
    
    private RedisManager redisManager;
    
    private static final String UT_PREFIX_KEY = "RI:SchRst:";
    private Boolean isCluster = Boolean.FALSE; 
    private SearchCacheClusterManager searchCacheClusterManager;
    
    private int expireTime = 60 * 3;//3分钟
    private static MessagePack msgpack = null;
    
    public SearchCacheManagerImpl(){}
    static {
		if (msgpack == null) {
			msgpack = new MessagePack();
			msgpack.register(SearchResult.class);
		}
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
     * @param SearchResult
     * @return
     */
    @SuppressWarnings("unused")
	private byte[] changeValueToByteArray(SearchResult SearchResult) {
        byte[] valueBytes = null;
        try {
            valueBytes = msgpack.write(SearchResult);
        } catch (Exception e) {
            log.error("change value to bytes failed.error info:" + e);
        }
        return valueBytes;
    }
    /**
     * 将对象集合序列化为ByteArray
     * */
    public byte[] changeObjectsToByteArray(List<SearchResult> SearchResults){
    	try
    	{
    		ByteArrayOutputStream out = new ByteArrayOutputStream();
    		Packer packer = msgpack.createPacker(out);
    		for(SearchResult SearchResult : SearchResults){
    			packer.write(SearchResult);
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
    @SuppressWarnings("unused")
	private SearchResult changeByteArrayToVal(byte[] bytes){
        try {
        	SearchResult SearchResult = msgpack.read(bytes, SearchResult.class);
            return SearchResult ;
        } catch (Exception e) {
            log.error("change bytes to star failed.error info:" + e);
        }
        return null;
    }
    /**
     * 将ByteArray反序列化为对象集合
     *
     * */
    public List<SearchResult> changeByteArrayToObjects(byte[] bytes){
        List<SearchResult> list = new ArrayList<SearchResult>();
        try
        {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            Unpacker unpacker = msgpack.createUnpacker(in);
            SearchResult SearchResult = null;
            do{
            	SearchResult = unpacker.read(SearchResult.class);
                if(SearchResult != null){
                    list.add(SearchResult);
                }
            }while (SearchResult != null);
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
	public List<SearchResult> queryByParam(String httpUrl, SearchRequest searchRequest) {
		if(isCluster){
			return searchCacheClusterManager.queryByParam(httpUrl, searchRequest);
		}
		Jedis jedis = null;
        try {
        	jedis = redisManager.getJedis();;
        } catch (Exception e) {
            log.error("redis getObject failed.error info:" + e);
        }
        if (jedis == null) {//redis为空，从数据库中获取
        	//通知搜索服务器
        	return SearchUtil.httpRequest(httpUrl, searchRequest);
        }
        //
        String id = SearchUtil.getSearchKey(searchRequest);
        String key = UT_PREFIX_KEY + id;
        byte[] keyBytes = changeKeyToByteArray(key);
//        jedis.del(keyBytes);
        List<SearchResult> rst = null;
        rst = changeByteArrayToObjects(jedis.get(keyBytes));
        
        if(rst == null || rst.isEmpty()){
        	log.debug("search from engine,id:"+id);
        	rst = SearchUtil.httpRequest(httpUrl, searchRequest);
        	if(rst == null || rst.isEmpty()){
        		rst = new ArrayList<SearchResult>();
        		//放置一个空对象进去，后期循环的时候去掉
        		rst.add(new SearchResult());
        	}
        	jedis.set(keyBytes, changeObjectsToByteArray(rst));
        	
        	jedis.expire(keyBytes, expireTime);
        }else if(log.isDebugEnabled()){
        	log.debug("search from redis,id:"+id);
        }
		return rst;
	}
	
	public RedisManager getRedisManager() {
		return redisManager;
	}
	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}
	public SearchCacheClusterManager getSearchCacheClusterManager() {
		return searchCacheClusterManager;
	}
	public void setSearchCacheClusterManager(SearchCacheClusterManager searchCacheClusterManager) {
		this.searchCacheClusterManager = searchCacheClusterManager;
	}
	public Boolean getIsCluster() {
		return isCluster;
	}
	public void setIsCluster(Boolean isCluster) {
		this.isCluster = isCluster;
	}
}
