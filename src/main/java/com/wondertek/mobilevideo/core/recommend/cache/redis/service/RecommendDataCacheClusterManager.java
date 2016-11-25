package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import java.util.List;

import com.wondertek.mobilevideo.core.recommend.vo.RecommendDataVo;

public interface RecommendDataCacheClusterManager {
	
	/**
	 * 根据 type protype 和 labelInfo 查询recommendDataVo
	 */
	public List<RecommendDataVo> queryByLabelInfo(List<String> types,String name, String labelInfo);

	public void updataCache();

}
