package com.wondertek.mobilevideo.core.recommend.util;

import java.util.Calendar;
import java.util.Date;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.cache.EnumsConfigCache;
import com.wondertek.mobilevideo.core.recommend.cache.EnumsInfoCache;
import com.wondertek.mobilevideo.core.recommend.cache.PrdTypeRelationCache;
import com.wondertek.mobilevideo.core.recommend.cache.SystemConfigCache;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.RecommendInfoCacheManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.TopRecommendCacheManager;
import com.wondertek.mobilevideo.core.recommend.cache.redis.service.VomsRecommendCacheManager;
import com.wondertek.mobilevideo.core.util.DateUtil;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class RecommendUtil {
	public static void init(){
		initSysCache();
		initRedisCache();
		initVomsRecommednRedisCache();
		initTopRecommednRedisCache();
	}
	public static void initTopRecommednRedisCache() {
		TopRecommendCacheManager topRecommendCacheManager = (TopRecommendCacheManager) Constants.ctx.getBean("topRecommendCacheManager");
		topRecommendCacheManager.updateCache();
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
	public static long getYYYYMMDDHHMMFormat(Date now){
		if(now == null){
			return 0;
		}
		return StringUtil.nullToLong(DateUtil.formatDate(RecommendConstants.DATE_FORMAT_YYYYMMDDHHMM, now));
	}
	public static long getYYYYMMDDHHMMFormatForDay(Date now , int dayOfYear){
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, 0 - dayOfYear);
		return getYYYYMMDDHHMMFormat(cal.getTime());
	}
}
