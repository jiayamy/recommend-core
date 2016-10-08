package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.SystemConfigDao;
import com.wondertek.mobilevideo.core.recommend.model.SystemConfig;
import com.wondertek.mobilevideo.core.recommend.service.SystemConfigService;

public class SystemConfigServiceImpl extends GenericManagerImpl<SystemConfig, Long> implements SystemConfigService {
	private SystemConfigDao systemConfigDao;
	public SystemConfigServiceImpl(SystemConfigDao systemConfigDao) {
		super(systemConfigDao);
		this.systemConfigDao = systemConfigDao;
	}

	@Override
	public Long getConfigCount(Map<String, Object> paramsMap) {
		return systemConfigDao.getConfigCount(paramsMap);
	}

	@Override
	public List<SystemConfig> getConfigList(Map<String, Object> paramsMap,int start, int limit) {
		return systemConfigDao.getConfigList(paramsMap, start, limit);
	}

	@Override
	public String getConfigValue(String configKey) {
		SystemConfig sc = systemConfigDao.getConfigByKey(configKey);
		if(sc != null) {
			return sc.getConfigValue();
		}
		return null;
	}

	@Override
	public Boolean isExistConfig(String key) {
		return systemConfigDao.isExistConfig(key);
	}

	@Override
	public void deleteById(Long id) {
		systemConfigDao.remove(id);
	}
}
