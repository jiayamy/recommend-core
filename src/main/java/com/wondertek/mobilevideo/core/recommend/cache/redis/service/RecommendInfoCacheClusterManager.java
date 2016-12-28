package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.recommend.vo.RecommendInfoVo;

public interface RecommendInfoCacheClusterManager {
    public List<RecommendInfoVo> queryByLabels(String labelNames, String prdType, String catId, Map<String,Double> labelScoreAndWeight);
    /**
     *每隔固定时间查询一次数据库，更新redis缓存
     *
     */
    public void updateCache();
}
