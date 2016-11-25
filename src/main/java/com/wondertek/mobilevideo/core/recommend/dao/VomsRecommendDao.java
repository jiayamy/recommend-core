package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendDataVo;

public interface VomsRecommendDao extends GenericDao<VomsRecommend, Long>{
	/**
	 * 
	 * @param 
	 * @param 
	 * @param 
	 * @return
	 */
	public List<VomsRecommend> queryByParam(String prdType, String type,String objType, Long objId);

	public List<VomsRecommend> getAllRecommend ();
	
	public List<RecommendDataVo> getRecommendDataVos(String type, String prdType, String labelInfo);
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