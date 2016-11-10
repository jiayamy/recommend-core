package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import java.util.List;

import com.wondertek.mobilevideo.core.recommend.vo.RecommendInfoVo;

public interface RecommendInfoCacheClusterManager {
	/**
     *根据人物ID找人物信息
     */
    public List<RecommendInfoVo> queryByLabel(String labelName, String prdType, String catId);
    
    public List<RecommendInfoVo> queryByLabels(String labelNames, String prdType, String catId);
    /**
     *每隔固定时间查询一次数据库，更新redis缓存
     *
     */
    public void updateCache();
}
