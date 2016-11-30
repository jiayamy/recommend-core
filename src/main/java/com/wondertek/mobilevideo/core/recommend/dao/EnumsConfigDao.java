package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsConfig;

public interface EnumsConfigDao extends GenericDao<EnumsConfig, Long> {
	
	public List<EnumsConfig> findByType(String type);
	
	public List<EnumsConfig> findByParent(String parent);
	
	public List<EnumsConfig> findAll();
}
