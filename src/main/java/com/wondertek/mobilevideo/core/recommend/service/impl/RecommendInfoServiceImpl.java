package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.RecommendInfoDao;
import com.wondertek.mobilevideo.core.recommend.model.RecommendInfo;
import com.wondertek.mobilevideo.core.recommend.service.RecommendInfoService;

public class RecommendInfoServiceImpl extends GenericManagerImpl<RecommendInfo, Long> implements RecommendInfoService {
	private RecommendInfoDao recommendInfoDao;
	public RecommendInfoServiceImpl(RecommendInfoDao recommendInfoDao) {
		super(recommendInfoDao);
		this.recommendInfoDao = recommendInfoDao;
	}
	@Override
	public List<RecommendInfo> queryByLabels(String labelNames, String prdType, String catId) {
		return recommendInfoDao.queryByLabels(labelNames, prdType, catId);
	}
	@Override
	public List<RecommendInfo> queryAllAvailable() {
		return recommendInfoDao.queryAllAvailable();
	}
	@Override
	public Long getCountByParam(Map<String, Object> paramsMap) {
		return recommendInfoDao.getCountByParam(paramsMap);
	}
	@Override
	public List<RecommendInfo> getByParam(Map<String, Object> paramsMap, int start, int limit) {
		return recommendInfoDao.getByParam(paramsMap, start, limit);
	}
	@Override
	public void deleteById(Long id) {
		recommendInfoDao.remove(id);
	}
	@Override
	public Boolean checkExist(String prdType, String catId, Long prdContId, Long id) {
		return recommendInfoDao.checkExist(prdType, catId, prdContId, id);
	}
	
}
