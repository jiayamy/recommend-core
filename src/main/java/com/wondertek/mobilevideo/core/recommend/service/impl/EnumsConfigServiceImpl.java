package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsConfigDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsConfig;
import com.wondertek.mobilevideo.core.recommend.service.EnumsConfigService;

public class EnumsConfigServiceImpl extends GenericManagerImpl<EnumsConfig,Long> implements EnumsConfigService{
	
	private EnumsConfigDao enumsConfigDao;

	public EnumsConfigServiceImpl(EnumsConfigDao enumsConfigDao) {
		super();
		this.enumsConfigDao = enumsConfigDao;
	}

	@Override
	public List<EnumsConfig> findByType(String type) {
		return enumsConfigDao.findByType(type);
	}

	@Override
	public List<EnumsConfig> findAll() {
		return enumsConfigDao.findAll();
	}

	@Override
	public List<EnumsConfig> findByParent(String parent) {
		return enumsConfigDao.findByParent(parent);
	}
	
	
}
