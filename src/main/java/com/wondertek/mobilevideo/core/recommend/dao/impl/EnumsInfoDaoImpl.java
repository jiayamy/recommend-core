package com.wondertek.mobilevideo.core.recommend.dao.impl;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsInfoDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;

public class EnumsInfoDaoImpl extends GenericDaoHibernate<EnumsInfo,Long> implements EnumsInfoDao {
	
	public EnumsInfoDaoImpl() {
		super(EnumsInfo.class);
	}
}
