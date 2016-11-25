package com.wondertek.mobilevideo.core.recommend.dao.impl;



import java.util.ArrayList;
import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.VomsRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.VomsRecommend;
import com.wondertek.mobilevideo.core.recommend.util.RecommendConstants;
import com.wondertek.mobilevideo.core.recommend.vo.RecommendDataVo;
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

	@Override
	public List<VomsRecommend> getAllRecommend() {
		StringBuffer hql = new StringBuffer("from VomsRecommend where isRecommend = ? order by updateTime desc,id desc");
		return this.query(hql.toString(),new Object[]{Boolean.TRUE});
	}
	
	@Override
	public List<RecommendDataVo> getRecommendDataVos(String type, String prdType, String labelInfo) {
		StringBuffer hql = new StringBuffer("select new RecommendDataVo(objId,name,objType) from VomsRecommend where status = ? and type=? and prdType=? ");
		List<Object> param = new ArrayList<Object>();
		param.add(RecommendConstants.VALID);
		param.add(type);
		param.add(prdType);
		
		//添加循环判断  labelInfo like %,tes1,% or labelInfo like %,tes2,%..
		int count = 0;
		hql.append(" and (");
		for (String labelName : labelInfo.split(RecommendConstants.SPLIT_COMMA)) {
			labelName = labelName.trim();
			if (!StringUtil.isNullStr(labelName)) {
				if (count != 0) {
					hql.append(" or");
				}
				hql.append("labelInfo like ?");
				param.add("%,"+labelName + ",%");
				count++;
			}
		}
		hql.append(")");
		return this.query(hql.toString(),param.toArray());
	}
}
