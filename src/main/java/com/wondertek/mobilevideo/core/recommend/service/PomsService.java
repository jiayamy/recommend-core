package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.vo.PrdContInfo;

public interface PomsService extends GenericManager<PrdContInfo, Long> {
	public List<PrdContInfo> getInfoByPrdContIds(List<Long> proContIds);

}
