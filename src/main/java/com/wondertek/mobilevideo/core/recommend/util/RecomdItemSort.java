package com.wondertek.mobilevideo.core.recommend.util;

import java.util.Comparator;

import com.wondertek.mobilevideo.core.recommend.vo.mongo.RecomdItem;

public class RecomdItemSort implements Comparator<RecomdItem>{
	@Override
	public int compare(RecomdItem o1, RecomdItem o2) {
		return o2.getScore().compareTo(o1.getScore());
	}
}