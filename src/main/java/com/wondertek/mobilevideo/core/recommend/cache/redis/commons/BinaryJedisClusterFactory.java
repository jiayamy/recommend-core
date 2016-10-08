package com.wondertek.mobilevideo.core.recommend.cache.redis.commons;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class BinaryJedisClusterFactory
{
	private Integer timeout;
	private Integer maxRedirections;
	private String address;
	private GenericObjectPoolConfig genericObjectPoolConfig;

	private BinaryJedisCluster jedisCluster;

	private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

	//TODO 从未写过初始化函数，如何有值？？？
	public BinaryJedisCluster getObject()  {
		return this.jedisCluster;
	}

	public Class <? extends BinaryJedisCluster> getObjectType() {
		return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
	}

	public boolean isSingleton() {
		return true;
	}

	private Set<HostAndPort> parseHostAndPort() throws Exception {
		try {
			String[] addrs = address.split(",");
			Set<HostAndPort> haps = new HashSet<HostAndPort>();
			for (String addr : addrs) {
				boolean isIpPort = p.matcher(addr).matches();
				if (!isIpPort) {
					throw new IllegalArgumentException("ip 或 port 不合法");
				}
				String[] ipAndPort = addr.split(":");
				HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
				haps.add(hap);
			}
			return haps;
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new Exception("解析 jedis 配置文件失败", ex);
		}
	}

	public void init() throws Exception {
		this.parseHostAndPort();
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Integer getMaxRedirections() {
		return maxRedirections;
	}

	public void setMaxRedirections(Integer maxRedirections) {
		this.maxRedirections = maxRedirections;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GenericObjectPoolConfig getGenericObjectPoolConfig() {
		return genericObjectPoolConfig;
	}

	public void setGenericObjectPoolConfig(
			GenericObjectPoolConfig genericObjectPoolConfig) {
		this.genericObjectPoolConfig = genericObjectPoolConfig;
	}
}
