package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.VomsRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.service.VomsRecommendService;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendDataVo;

public class VomsRecommendServiceImpl extends GenericManagerImpl<VomsRecommend, Long>implements VomsRecommendService {
	private VomsRecommendDao vomsRecommendDao;

	public VomsRecommendServiceImpl(VomsRecommendDao vomsRecommendDao) {
		super(vomsRecommendDao);
		this.vomsRecommendDao = vomsRecommendDao;
	}
	
	@Override
	public List<VomsRecommend> queryByParam(String prdType, String type, String objType, Long objId) {
		return vomsRecommendDao.queryByParam(prdType, type, objType, objId);
	}
	@Override
	public List<VomsRecommend> getAllRecommend() {
		return vomsRecommendDao.getAllRecommend();
	}
	@Override
	public List<RecommendDataVo> getRecommendDataVos(List<String> types, String prdType, String labelInfo){
		return vomsRecommendDao.getRecommendDataVos(types, prdType, labelInfo);
		
	}
	@Override
	public List<VomsRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit) {		
		return vomsRecommendDao.getByParam(paramsMap, start, limit);
	}

	@Override
	public Long getCountByParam(Map<String, Object> paramsMap) {		
		return vomsRecommendDao.getCountByParam(paramsMap);
	}
}
