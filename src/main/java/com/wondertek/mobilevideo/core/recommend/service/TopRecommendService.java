package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.TopRecommend;

public interface TopRecommendService  extends GenericManager<TopRecommend, Long>{
	/**
	 * 根据prdType查找
	 * 
	 */
	public List<TopRecommend> queryValidByParam(String prdType);	
	/**
	 * 定时扫描所有有效地置顶推荐信息
	 * @return
	 */
	public List<TopRecommend> queryAllAvailable();
	/**
	 * 按页搜索
	 * @param paramsMap
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<TopRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit);
	public Long getCountByParam(Map<String, Object> paramsMap);
	/**
	 *检查是否存在 
	 */
	public Boolean checkExist(Long topId,String prdType,String topName,Long id);

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id);	
}
