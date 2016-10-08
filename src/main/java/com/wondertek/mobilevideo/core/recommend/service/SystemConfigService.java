package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.SystemConfig;

public interface SystemConfigService extends GenericManager<SystemConfig, Long> {

	/**
	 * 根据参数获取系统参数数目
	 * @param paramsMap
	 * @return 参数数目
	 */
	Long getConfigCount(Map<String, Object> paramsMap);

	/**
	 * 根据参数获取系统参数列表
	 * @param paramsMap
	 * @param start
	 * @param limit
	 * @return 参数list
	 */
	List<SystemConfig> getConfigList(Map<String, Object> paramsMap, int start,int limit);
	/**
	 * 根据key获取配置的值
	 * @param configKey
	 * @return
	 */
	public String getConfigValue(String configKey);
	
	/**
	 * 根据键值判断配置是否已存在
	 * @param key
	 * @return
	 */
	Boolean isExistConfig(String key);

	/**
	 * 根据id删除记录
	 * @param id
	 */
	void deleteById(Long id);
}
