package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;

public interface VomsRecommendService  extends GenericManager<VomsRecommend, Long>{
	/**
	 * 
	 * @param 
	 * @param 
	 * @param 
	 * @return
	 */
	public List<VomsRecommend> queryByParam(String prdType, String type,String objType, Long objId);
	/**
	 * 按页搜索
	 * @param paramsMap
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<VomsRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit);
	public Long getCountByParam(Map<String, Object> paramsMap);

}
