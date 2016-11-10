package com.wondertek.mobilevideo.core.recommend.service.impl;


import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.VomsRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.service.VomsRecommendService;

public class VomsRecommendServiceImpl extends GenericManagerImpl<VomsRecommend, Long> implements VomsRecommendService {
	private VomsRecommendDao vomsRecommendDao;
	
	public VomsRecommendServiceImpl(VomsRecommendDao vomsRecommendDao) {
		super(vomsRecommendDao);
		this.vomsRecommendDao = vomsRecommendDao;
	}
	
	@Override
	public VomsRecommend queryByParam(String prdType, int type, Long objId) {
		return vomsRecommendDao.queryByParam(prdType, type, objId);
	}
	
}
