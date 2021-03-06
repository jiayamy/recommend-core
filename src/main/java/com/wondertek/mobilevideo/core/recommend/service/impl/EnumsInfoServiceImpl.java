package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsInfoDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;
import com.wondertek.mobilevideo.core.recommend.service.EnumsInfoService;

public class EnumsInfoServiceImpl extends GenericManagerImpl<EnumsInfo, Long> implements EnumsInfoService {
	private EnumsInfoDao enumsInfoDao;
	
	public EnumsInfoServiceImpl(EnumsInfoDao enumsInfoDao) {
		super(enumsInfoDao);
		this.enumsInfoDao = enumsInfoDao;
	}

	@Override
	public List<EnumsInfo> queryByType(int type) {
		return enumsInfoDao.queryByType(type);
	}

	
	
}
