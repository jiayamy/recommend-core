package com.wondertek.mobilevideo.core.recommend.dao;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;

public interface VomsRecommendDao extends GenericDao<VomsRecommend, Long>{	
	public VomsRecommend queryByParam(String prdType, int type, Long objId);
}