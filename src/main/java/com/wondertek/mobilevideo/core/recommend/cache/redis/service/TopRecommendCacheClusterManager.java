package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import java.util.List;

import com.wondertek.mobilevideo.core.recommend.vo.RecommendTopVo;

public interface TopRecommendCacheClusterManager {
	
	/**
	 * 根据人物ID找人物信息
	 */	
	public List<RecommendTopVo> queryTopVos(String prdType);
	
	/**
     *每隔固定时间查询一次数据库，更新redis缓存
     *
     */
	public void updataCache();
}
