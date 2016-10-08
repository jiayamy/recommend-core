package com.wondertek.mobilevideo.core.recommend.service.impl;

import com.wondertek.mobilevideo.core.base.GenericManagerImpl;
import com.wondertek.mobilevideo.core.recommend.dao.PrdTypeRelationDao;
import com.wondertek.mobilevideo.core.recommend.model.PrdTypeRelation;
import com.wondertek.mobilevideo.core.recommend.service.PrdTypeRelationService;

public class PrdTypeRelationServiceImpl extends GenericManagerImpl<PrdTypeRelation, Long> implements PrdTypeRelationService {
	private PrdTypeRelationDao PrdTypeRelationDao;
	public PrdTypeRelationServiceImpl(PrdTypeRelationDao PrdTypeRelationDao) {
		super(PrdTypeRelationDao);
		this.PrdTypeRelationDao = PrdTypeRelationDao;
	}
	
}
