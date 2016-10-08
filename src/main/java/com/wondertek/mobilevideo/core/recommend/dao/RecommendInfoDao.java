package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.RecommendInfo;

public interface RecommendInfoDao extends GenericDao<RecommendInfo, Long> {
	/**
	 * 通过标签查询内容，标签可多个，英文逗号分隔，查询所有包含这些标签的内容
	 * @param labelNames
	 * @param prdType
	 * @param catId
	 * @return
	 */
	public List<RecommendInfo> queryByLabels(String labelNames, String prdType, String catId);
	/**
	 * 定时扫描所有有效地人工推荐信息
	 * @return
	 */
	public List<RecommendInfo> queryAllAvailable();
	/**
	 * 按页搜索
	 * @param paramsMap
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<RecommendInfo> getByParam(Map<String, Object> paramsMap, int start, int limit);
	public Long getCountByParam(Map<String, Object> paramsMap);
	/**
	 * 检查是否存在
	 * @param prdType
	 * @param catId
	 * @param prdContId
	 * @param id
	 * @return
	 */
	public Boolean checkExist(String prdType, String catId, Long prdContId, Long id);
}
