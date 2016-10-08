package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.bean.ParamBean;
import com.wondertek.mobilevideo.core.recommend.bean.ResultBean;
import com.wondertek.mobilevideo.core.recommend.model.SystemConfig;

public interface SystemConfigDao extends GenericDao<SystemConfig, Long> {

	/**
	 * 更新系统参数
	 * @param sys
	 * @return
	 */
	boolean updateConfig(SystemConfig sys);
	
	/**
	 * 查询系统参数列表
	 * @param params
	 * @return
	 */
	ResultBean queryConfigList(ParamBean params);
	/**
	 * 根据键值查询系统参数
	 * @param key
	 * @return
	 */
	SystemConfig querySystemConfig(String key);
	
	/**
	 * 根据参数获取系统参数数目
	 * @param paramsMap
	 * @return系统参数数目
	 */
	Long getConfigCount(Map<String, Object> paramsMap);
	
	/**
	 * 根据参数获取系统参数列表
	 * @param paramsMap
	 * @param start
	 * @param limit
	 * @return系统参数列表
	 */
	List<SystemConfig> getConfigList(Map<String, Object> paramsMap, int start, int limit);
	
	/**
	 * 根据key获取配置的值
	 * @param configKey
	 * @return
	 */
	public SystemConfig getConfigByKey(String configKey);
	
	/**
	 * 根据键值判断配置是否已存在
	 * @param key
	 * @return
	 */
	Boolean isExistConfig(String key);
}
