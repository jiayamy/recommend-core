package com.wondertek.mobilevideo.core.recommend.dao.impl;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.PrdTypeRelationDao;
import com.wondertek.mobilevideo.core.recommend.model.PrdTypeRelation;

public class PrdTypeRelationDaoImpl extends GenericDaoHibernate<PrdTypeRelation,Long> implements PrdTypeRelationDao {
	
	public PrdTypeRelationDaoImpl() {
		super(PrdTypeRelation.class);
	}
}
