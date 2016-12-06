package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import java.util.List;

import com.wondertek.mobilevideo.core.recommend.vo.VomsRecommendVo;

public interface VomsRecommendCacheManager {
	
	/**
	 * 根据 type protype 和 labelInfo 查询VomsRecommendVo
	 */
	public List<VomsRecommendVo> queryByLabelInfo(List<String> types, String prdType, String labelInfo);	
	public void updataCache();
}
