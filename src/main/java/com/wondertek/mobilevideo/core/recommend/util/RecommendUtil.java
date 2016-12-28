package com.wondertek.mobilevideo.core.recommend.util;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.cache.EnumsConfigCache;
import com.wondertek.mobilevideo.core.recommend.cache.EnumsInfoCache;
import com.wondertek.mobilevideo.core.recommend.cache.PrdTypeRelationCache;
import com.wondertek.mobilevideo.core.recommend.cache.SystemConfigCache;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.VomsRecommendCacheManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendInfoCacheManager;

public class RecommendUtil {
	public static void init(){
		initSysCache();
		initRedisCache();
		initVomsRecommednRedisCache();
	}
	public static void initRedisCache() {
		RecommendInfoCacheManager recommendInfoCacheManager = (RecommendInfoCacheManager) Constants.ctx.getBean("recommendInfoCacheManager");
		recommendInfoCacheManager.updateCache();
	}
	/**
	 * 初始化缓存
	 */
	public static void initSysCache() {
		SystemConfigCache.init(null);
		EnumsInfoCache.init();
		PrdTypeRelationCache.init();
		//2016-12-19 推荐权重信息
		EnumsConfigCache.init();
	}
	/**
	 * 初始化RecommednDataRedi缓存
	 */
	public static void initVomsRecommednRedisCache() {
		VomsRecommendCacheManager vomsRecommendCacheManager = (VomsRecommendCacheManager) Constants.ctx.getBean("vomsRecommendCacheManager");
		vomsRecommendCacheManager.updataCache();
	}
}
