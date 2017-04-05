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

import com.wondertek.mobilevideo.core.recommend.cache.redis.commons.BinaryJedisClusterFactory;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.SearchCacheClusterManager;
import com.wondertek.mobilevideo.core.recommend.search.SearchRequest;
import com.wondertek.mobilevideo.core.recommend.search.SearchResult;
import com.wondertek.mobilevideo.core.recommend.search.SearchUtil;

import redis.clients.jedis.BinaryJedisCluster;

public class SearchCacheClusterManagerImpl implements SearchCacheClusterManager{

    public static Object obj = new Object();
    
    private Log log = LogFactory.getLog(this.getClass());   
    
    private BinaryJedisClusterFactory jedisClusterFactory;  
        
    private static final String UT_PREFIX_KEY = "RI:CLUSTER:SchRst:";
    
    private int expireTime = 60 * 3;//3分钟
    
    private static MessagePack msgpack = null;
    
    public SearchCacheClusterManagerImpl(){}
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
        	log.debug("change key to bytes failed.error info:" + e);
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
        	log.debug("change value to bytes failed.error info:" + e);
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
    		log.debug("write val object to byteArray error:"+e);
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
    		log.debug("write val object to byteArray error:"+e);
    		return  null;
    	}
    }
    @SuppressWarnings("unused")
	private SearchResult changeByteArrayToVal(byte[] bytes){
        try {
        	SearchResult SearchResult = msgpack.read(bytes, SearchResult.class);
            return SearchResult ;
        } catch (Exception e) {
        	log.debug("change bytes to star failed.error info:" + e);
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
        	log.debug("change byteArray to objects error:"+e);
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
        	log.debug("change byteArray to objects error:"+e);
            return list;
        }
    }
	@Override
	public List<SearchResult> queryByParam(String httpUrl, SearchRequest searchRequest) {
		BinaryJedisCluster jedisCluster = null;
		try{
			jedisCluster = jedisClusterFactory.getObject();
		}catch(Exception e){
			log.error("redis getObject failed.error info:" + e);
		}
        if(jedisCluster == null){//redis为空，直接从搜索获取
        	//通知搜索服务器
        	return SearchUtil.httpRequest(httpUrl, searchRequest);
        }
        //
        String id = SearchUtil.getSearchKey(searchRequest);
        String key = UT_PREFIX_KEY + id;
        byte[] keyBytes = changeKeyToByteArray(key);
//        jedisCluster.del(keyBytes);
        List<SearchResult> rst = null;
        rst = changeByteArrayToObjects(jedisCluster.get(keyBytes));      
        
        if(rst == null || rst.isEmpty()){
        	log.debug("search from engine,id:"+id);
        	rst = SearchUtil.httpRequest(httpUrl, searchRequest);
        	if(rst == null || rst.isEmpty()){
        		rst = new ArrayList<SearchResult>();
        		//放置一个空对象进去，后期循环的时候去掉
        		rst.add(new SearchResult());
        	}
        	jedisCluster.set(keyBytes, changeObjectsToByteArray(rst));        	
        	jedisCluster.expire(keyBytes, expireTime);
        }else if(log.isDebugEnabled()){
        	log.debug("search from redis,id:"+id);
        }
		return rst;
	}
	public BinaryJedisClusterFactory getJedisClusterFactory() {
		return jedisClusterFactory;
	}
	public void setJedisClusterFactory(BinaryJedisClusterFactory jedisClusterFactory) {
		this.jedisClusterFactory = jedisClusterFactory;
	}
	
	
}
