package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.TopRecommend;

public interface TopRecommendDao extends GenericDao<TopRecommend, Long>{
	/**
	 * 通过prdType查询内容，查询所有的内容
	 * @param 	 prdType	
	 * @return
	 */
	public List<TopRecommend> queryByParam(String prdType);
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
	 * 检查是否存在
	 * 
	 */
	public Boolean checkExist(Long tId,String prdType,String topName,Long id);	
}