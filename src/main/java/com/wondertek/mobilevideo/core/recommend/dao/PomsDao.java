package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDao;
import com.wondertek.mobilevideo.core.recommend.vo.PrdContInfo;

public interface PomsDao extends GenericDao<PrdContInfo, Long>{
	public List<PrdContInfo> getInfoByPrdContIds(List<Long> proContIds);
}
