package com.wondertek.mobilevideo.core.recommend.service;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;

public interface VomsRecommendService  extends GenericManager<VomsRecommend, Long>{

	public VomsRecommend queryByParam(String prdType, int type, Long objId);
	
}
