package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.PomsDao;
import com.wondertek.mobilevideo.core.recommend.service.PomsService;
import com.wondertek.mobilevideo.core.recommend.vo.PrdContInfo;

public class PomsServiceImpl extends GenericManagerImpl<PrdContInfo, Long>  implements PomsService {
	private PomsDao pomsDao;
	
	public PomsServiceImpl(PomsDao pomsDao) {
		this.pomsDao = pomsDao;
	}

	@Override
	public List<PrdContInfo> getInfoByPrdContIds(List<Long> proContIds) {
		return pomsDao.getInfoByPrdContIds(proContIds);
	}
}
