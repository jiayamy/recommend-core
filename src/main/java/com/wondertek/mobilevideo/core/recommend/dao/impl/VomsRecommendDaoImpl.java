package com.wondertek.mobilevideo.core.recommend.dao.impl;



import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.VomsRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;

public class VomsRecommendDaoImpl extends GenericDaoHibernate<VomsRecommend,Long> implements VomsRecommendDao{

	public VomsRecommendDaoImpl() {
		super(VomsRecommend.class);
	}

	@Override
	public VomsRecommend queryByParam(String prdType, int type, Long objId) {
		String hql = "from VomsRecommend where prdType = ? type=? and objId=?";
		List<VomsRecommend> list = this.query(hql, new Object[]{ prdType,type,objId });
		if(list != null && list.size()>0) {
			return list.get(0);
		}else {
			return null;	
		}		
	}	
}
