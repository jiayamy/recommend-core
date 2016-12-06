package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;

public interface EnumsInfoService extends GenericManager<EnumsInfo, Long> {
	
	public List<EnumsInfo> queryByType(int type);
}
