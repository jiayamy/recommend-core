package com.wondertek.mobilevideo.core.recommend.dao.impl;



import java.util.ArrayList;
import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.VomsRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class VomsRecommendDaoImpl extends GenericDaoHibernate<VomsRecommend,Long> implements VomsRecommendDao{

	public VomsRecommendDaoImpl() {
		super(VomsRecommend.class);
	}
	
	@Override
	 public List<VomsRecommend> queryByParam(String prdType, String type,String objType, Long objId) { 
	      List<Object> param = new ArrayList<Object>(); 
    	  StringBuffer hql = new StringBuffer("from VomsRecommend where objType=? and objId=?"); 
    	  param.add(objId); 
          param.add(objType); 
    	  if(!StringUtil.isNullStr(type)){ 
    		  hql.append(" and type = ?"); 
    		  param.add(type); 
    	  } 
    	  if(!StringUtil.isNullStr(prdType)){ 
    		  hql.append(" and prdType = ?"); 
    		  param.add(prdType); 
    	  }    	
    	  return this.query(hql.toString(),param.toArray()); 
	}
}
