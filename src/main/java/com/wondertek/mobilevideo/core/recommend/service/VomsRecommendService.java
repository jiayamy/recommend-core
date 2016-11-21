package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;

public interface VomsRecommendService  extends GenericManager<VomsRecommend, Long>{

	public List<VomsRecommend> queryByParam(String prdType, String type,String objType,Long objId);
	
}
