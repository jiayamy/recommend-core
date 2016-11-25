package com.wondertek.mobilevideo.core.recommend.util;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.cache.EnumsInfoCache;
import com.wondertek.mobilevideo.core.recommend.cache.PrdTypeRelationCache;
import com.wondertek.mobilevideo.core.recommend.cache.SystemConfigCache;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendDataCacheManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendInfoCacheManager;

public class RecommendUtil {
	public static void init(){
		initSysCache();
		initRedisCache();
		initRecommednDataRedisCache();
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
	}
	/**
	 * 初始化RecommednDataRedi缓存
	 */
	public static void initRecommednDataRedisCache() {
		RecommendDataCacheManager recommendDataCacheManager = (RecommendDataCacheManager) Constants.ctx.getBean("recommendDataCacheManager");
		recommendDataCacheManager.updataCache();
	}
}
