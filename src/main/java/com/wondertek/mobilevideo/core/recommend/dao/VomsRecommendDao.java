package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;

public interface VomsRecommendDao extends GenericDao<VomsRecommend, Long>{	
	public List<VomsRecommend> queryByParam(String prdType, String type,String objType, Long objId);
}