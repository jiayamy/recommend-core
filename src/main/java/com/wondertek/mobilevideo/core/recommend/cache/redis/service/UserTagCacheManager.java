package com.wondertek.mobilevideo.core.recommend.cache.redis.service;

import com.wondertek.mobilevideo.core.recommend.vo.mongo.UserTag;

/**
 * 用户标签信息
 * @author lvliuzhong
 *
 */
public interface UserTagCacheManager
{
    /**
     *根据用户ID查找用户标签信息
     *@param id
     *@return 返回一个对象，或者空，或者空对象
     */
    public UserTag queryById(String id);
    /**
     * 查询经过删减的用户标签
     * @param userId
     * @return
     */
	public UserTag queryCutById(String userId);
}
