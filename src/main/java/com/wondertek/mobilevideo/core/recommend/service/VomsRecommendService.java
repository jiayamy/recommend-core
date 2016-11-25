package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendDataVo;

public interface VomsRecommendService  extends GenericManager<VomsRecommend, Long>{

	public List<VomsRecommend> queryByParam(String prdType, String type,String objType,Long objId);
	
	public List<VomsRecommend> getAllRecommend();
	
	public List<RecommendDataVo> getRecommendDataVos(String type, String prdType, String labelInfo);
	
	
	
	
}
