package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    	  StringBuffer hql = new StringBuffer("from VomsRecommend where objType = ? and objId = ?"); 
    	  List<Object> param = new ArrayList<Object>(); 
          param.add(objType);
          param.add(objId);
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
	public List<VomsRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit) {
		StringBuffer hql = new StringBuffer("from VomsRecommend where 1 = 1");
        List<Object> params = new ArrayList<Object>();
		Object id = paramsMap.get("id");
        if (id != null) {
        	hql.append(" and id = ?");
        	params.add(id);
        }
        Object objId = paramsMap.get("objId");
        if (objId != null) {
        	hql.append(" and objId = ?");
        	params.add(objId);
        }
        String labelInfo = (String) paramsMap.get("labelInfo");
        if(labelInfo != null){
	        int count = 0;
			hql.append(" and (");
			for(String labelName : labelInfo.split(RecommendConstants.SPLIT_COMMA)){
				labelName = labelName.trim();
				if(!StringUtil.isNullStr(labelName)){
					if(count != 0){
						hql.append(" or ");
					}
					hql.append("labelInfo like ?");
					params.add("%" + labelName + "%");
					count ++;
				}
			}
			hql.append(")");
        }
        Object prdType = paramsMap.get("prdType");
        if (prdType != null) {
        	hql.append(" and prdType = ?");
        	params.add(prdType);
        }
        Object objType = paramsMap.get("objType");
        if (objType != null) {
        	hql.append(" and catId = ?");
        	params.add(objType);
        }
        Object type = paramsMap.get("type");
        if (type != null) {
        	hql.append(" and type = ?");
        	params.add(type);
        }
        Object name = paramsMap.get("name");
        if (name != null) {
        	hql.append(" and name like ?");
        	params.add("%" + name + "%");
        }
        Object isRecommend = paramsMap.get("isRecommend");
        if (isRecommend != null) {
        	hql.append(" and isRecommend = ?");
        	params.add(isRecommend);
        }
        
        if (!StringUtil.isNullStr(paramsMap.get("sidx"))) {
        	hql.append(" ORDER BY ")
        		.append(paramsMap.get("sidx")).append(" ").append(paramsMap.get("sord"));
    		
        	if(!paramsMap.get("sidx").equals("id")){
    			hql.append(", id desc");
    		}
	    } else {
	    	hql.append(" ORDER BY id DESC ");
	    }
        
        if (start == 0 && limit == 0) {
        	return this.query(hql.toString(), params.toArray());
        } else {
        	return this.query(hql.toString(), params.toArray(), start, limit);
        }
	}

	@Override
	public Long getCountByParam(Map<String, Object> paramsMap) {
		StringBuffer hql = new StringBuffer("select count(id) from VomsRecommend where 1 = 1");
        List<Object> params = new ArrayList<Object>();        
        Object id = paramsMap.get("id");
        if (id != null) {
        	hql.append(" and id = ?");
        	params.add(id);
        }
        Object objId = paramsMap.get("objId");
        if (objId != null) {
        	hql.append(" and objId = ?");
        	params.add(objId);
        }
        String labelInfo = (String) paramsMap.get("labelInfo");
        if(labelInfo != null){
	        int count = 0;
			hql.append(" and (");
			for(String labelName : labelInfo.split(RecommendConstants.SPLIT_COMMA)){
				labelName = labelName.trim();
				if(!StringUtil.isNullStr(labelName)){
					if(count != 0){
						hql.append(" or ");
					}
					hql.append("labelInfo like ?");
					params.add("%" + labelName + "%");
					count ++;
				}
			}
			hql.append(")");
        }
        Object prdType = paramsMap.get("prdType");
        if (prdType != null) {
        	hql.append(" and prdType = ?");
        	params.add(prdType);
        }
        Object objType = paramsMap.get("objType");
        if (objType != null) {
        	hql.append(" and catId = ?");
        	params.add(objType);
        }
        Object type = paramsMap.get("type");
        if (type != null) {
        	hql.append(" and type = ?");
        	params.add(type);
        }
        Object name = paramsMap.get("name");
        if (name != null) {
        	hql.append(" and name like ?");
        	params.add("%" + name + "%");
        }
        Object isRecommend = paramsMap.get("isRecommend");
        if (isRecommend != null) {
        	hql.append(" and isRecommend = ?");
        	params.add(isRecommend);
        }       
		return this.count(hql.toString(), params.toArray());
	}
}
