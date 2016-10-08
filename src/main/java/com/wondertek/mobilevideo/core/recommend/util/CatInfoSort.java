package com.wondertek.mobilevideo.core.recommend.util;

import java.util.Comparator;

import com.wondertek.mobilevideo.core.recommend.vo.mongo.CatInfo;

public class CatInfoSort implements Comparator<CatInfo>{
	@Override
	public int compare(CatInfo o1, CatInfo o2) {
		return o2.getScore().compareTo(o1.getScore());
	}
}