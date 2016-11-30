package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsInfoDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;

public class EnumsInfoDaoImpl extends GenericDaoHibernate<EnumsInfo,Long> implements EnumsInfoDao {
	
	public EnumsInfoDaoImpl() {
		super(EnumsInfo.class);
	}

	@Override
	public List<EnumsInfo> queryByType(int type) {
		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("from EnumsInfo where type = ?");
		params.add(type);
		
		return this.query(sb.toString(), params.toArray());
	}
}
