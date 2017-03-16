package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.vo.VomsRecommendVo;

public interface VomsRecommendService  extends GenericManager<VomsRecommend, Long>{
	/**
	 * 根据参数查询记录
	 * @return
	 */
	public List<VomsRecommend> queryByParam(String prdType, String type,String objType, Long objId);
	/**
	 * 按页搜索
	 * @return
	 */
	public List<VomsRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit);
	public Long getCountByParam(Map<String, Object> paramsMap);
	/**
	 * 获取所有推荐的数据
	 * @return
	 */
	public List<VomsRecommend> getAllRecommend();
	/**
	 * 根据标签查询所有推荐数据
	 * @return
	 */
	public List<VomsRecommendVo> getVomsRecommendVos(List<String> types, String prdType, String labelInfo);
	/**
	 * 批量更新是否推荐
	 */
	public void updateIsRecommend(List<Long> ids, Boolean isRecommend, String updator);
}
