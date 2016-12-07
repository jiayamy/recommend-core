package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;



public interface EnumsInfoDao extends GenericDao<EnumsInfo, Long> {
	
	public List<EnumsInfo> queryByType(int type);
	
}	
