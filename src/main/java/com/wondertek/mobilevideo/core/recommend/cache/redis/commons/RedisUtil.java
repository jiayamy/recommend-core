package com.wondertek.mobilevideo.core.recommend.cache.redis.commons;

import static org.msgpack.template.Templates.TString;
import static org.msgpack.template.Templates.tMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.unpacker.Unpacker;

public class RedisUtil
{
	public static MessagePack msgpack = new MessagePack();
	public static Template<Map<String,String>> mapTpl = tMap(TString, TString);

	/**
	 * 将key转化为ByteArray
	 * @param key
	 * @return
	 */
	public static byte[] changeKeyToByteArray(String key) {
		//MessagePack msgpack = new MessagePack();
		byte[] keyBytes = null;
		try {
			keyBytes = msgpack.write(key);
		} catch (IOException e) {
			System.out.println("change key to bytes failed. Error info:" + e);
		}
		return keyBytes;
	}

	/**
	 * 将单个对象序列化为ByteArray
	 * */
	public static byte[] changeValueToByteArray(Object object) {
		byte[] valueBytes = null;
		try {
			valueBytes = msgpack.write(object);
		} catch (IOException e) {
			System.out.println("change value to bytes failed. Error info:" + e);
		}
		return valueBytes;
	}

	/**
	 * 将MAP序列化为ByteArray
	 * */
	public static byte[] changeMapToByteArray(Map<String,String> map){
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Packer packer = msgpack.createPacker(out);
			packer.write(map);
			return out.toByteArray();
		}catch (Exception e){
			System.out.println("write Map object to byteArray, error:"+e);
			return  null;
		}
	}

	/**
	 * 将ByteArray反序列化为MAP对象
	 *
	 * */
	public static Map<String,String> changeByteArrayToMap(byte[] bytes){
		try
		{
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			Unpacker unpacker = msgpack.createUnpacker(in);
			return unpacker.read(mapTpl);
		}catch (Exception e){
			System.out.println("change byteArray to objects error:"+e);
			return null;
		}
	}


}
