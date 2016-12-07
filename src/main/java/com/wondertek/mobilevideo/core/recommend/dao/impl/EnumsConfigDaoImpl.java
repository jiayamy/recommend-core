package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsConfigDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsConfig;

public class EnumsConfigDaoImpl extends GenericDaoHibernate<EnumsConfig,Long> implements EnumsConfigDao{

	public EnumsConfigDaoImpl() {
		super(EnumsConfig.class);
	}

	@Override
	public List<EnumsConfig> findByType(String type) {
		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("from EnumsConfig where type = ? order by id");
		params.add(type);
		
		return this.query(sb.toString(), params.toArray());
	}

	@Override
	public List<EnumsConfig> findByParent(String parent) {
		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("from EnumsConfig where parent = ? order by id");
		params.add(parent);
		
		return this.query(sb.toString(), params.toArray());
	}

	@Override
	public List<EnumsConfig> findAll() {
		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("from EnumsConfig order by id");
		
		
		return this.query(sb.toString());
	}	
	

	@Override
	public Boolean checkExist(String key, String parent,String type) {
		StringBuffer hql = new StringBuffer("select count(id) from EnumsConfig where key = ? and parent = ? and type = ?");
		List<Object> params = new ArrayList<Object>();
        params.add(key);
        params.add(parent);
        params.add(type);
		return this.count(hql.toString(),params.toArray())>0;
	}


	
}
