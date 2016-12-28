package com.wondertek.mobilevideo.core.recommend.util;

import java.util.Comparator;

import com.wondertek.mobilevideo.core.recommend.vo.RecommendInfoVo;
/**
 * 分数从高到低排序
 * @author lvliuzhong
 *
 */
public class RecommendInfoVoSort implements Comparator<RecommendInfoVo>{
	@Override
	public int compare(RecommendInfoVo o1, RecommendInfoVo o2) {
		return o2.getScore().compareTo(o1.getScore());
	}
}