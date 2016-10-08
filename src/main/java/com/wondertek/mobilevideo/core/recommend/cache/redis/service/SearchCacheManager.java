package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import java.util.List;

import com.wondertek.mobilevideo.core.recommend.search.SearchRequest;
import com.wondertek.mobilevideo.core.recommend.search.SearchResult;

/**
 * 用户标签信息
 * @author lvliuzhong
 *
 */
public interface SearchCacheManager
{
    /**
     * 搜索，先从缓存找，如果缓存没有就从搜索服务器查找
     *@param searchRequest
     */
    public List<SearchResult> queryByParam(String httpUrl, SearchRequest searchRequest);
}
