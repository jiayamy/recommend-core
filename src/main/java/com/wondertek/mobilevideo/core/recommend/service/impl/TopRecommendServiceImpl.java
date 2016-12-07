package com.wondertek.mobilevideo.core.recommend.service.impl;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.TopRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.TopRecommend;
import com.wondertek.mobilevideo.core.recommend.service.TopRecommendService;

public class TopRecommendServiceImpl extends GenericManagerImpl<TopRecommend, Long>implements TopRecommendService {
	private TopRecommendDao topRecommendDao;

	public TopRecommendServiceImpl(TopRecommendDao topRecommendDao) {
		super(topRecommendDao);
		this.setTopRecommendDao(topRecommendDao);
	}

	@Override
	public List<TopRecommend> queryByParam(Long objId, String prdType, String topName) {
		return topRecommendDao.queryByParam(objId, prdType, topName);
	}

	@Override
	public List<TopRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit) {
		return topRecommendDao.getByParam(paramsMap, start, limit);
	}

	@Override
	public Long getCountByParam(Map<String, Object> paramsMap) {
		return topRecommendDao.getCountByParam(paramsMap);
	}
	
	@Override
	public Boolean checkExist(Long tId,String prdType,String topName,Long id) {
		return topRecommendDao.checkExist(tId, prdType, topName,id);
	}
	
	@Override
	public void deleteById(Long id) {
		topRecommendDao.remove(id);		
	}
	
	public TopRecommendDao getTopRecommendDao() {
		return topRecommendDao;
	}

	public void setTopRecommendDao(TopRecommendDao topRecommendDao) {
		this.topRecommendDao = topRecommendDao;
	}	
}
