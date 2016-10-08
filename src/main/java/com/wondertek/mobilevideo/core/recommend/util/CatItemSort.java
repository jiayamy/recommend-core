package com.wondertek.mobilevideo.core.recommend.util;

import java.util.Comparator;

import com.wondertek.mobilevideo.core.recommend.vo.mongo.CatItem;

public class CatItemSort implements Comparator<CatItem>{
	@Override
	public int compare(CatItem o1, CatItem o2) {
		return o2.getScore().compareTo(o1.getScore());
	}
}