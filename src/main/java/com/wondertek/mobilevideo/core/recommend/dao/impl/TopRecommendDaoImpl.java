package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.TopRecommendDao;
import com.wondertek.mobilevideo.core.recommend.model.TopRecommend;
import com.wondertek.mobilevideo.core.recommend.util.RecommendConstants;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class TopRecommendDaoImpl extends GenericDaoHibernate<TopRecommend,Long> implements TopRecommendDao{

	public TopRecommendDaoImpl() {
		super(TopRecommend.class);		
	}

	@Override
	public List<TopRecommend> queryValidByParam(String prdType) {
		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("from TopRecommend where status = ? and prdType = ?");
		params.add(RecommendConstants.VALID);		
		params.add(prdType);		
		return this.query(sb.toString(),params.toArray());
	}

	@Override
	public List<TopRecommend> queryAllAvailable() {
		return this.query("from TopRecommend where status = ? order by updateTime desc,id desc", new Object[]{RecommendConstants.VALID});
	}
	@Override
	public List<TopRecommend> getByParam(Map<String, Object> paramsMap, int start, int limit) {
		StringBuffer hql = new StringBuffer("from TopRecommend where 1 = 1");
        List<Object> params = new ArrayList<Object>();
		Object id = paramsMap.get("id");
        if (id != null) {
        	hql.append(" and id = ?");
        	params.add(id);
        }
        
        Object topId = paramsMap.get("topId");
        if (topId != null) {
        	hql.append(" and topId = ?");
        	params.add(topId);
        }
        
        Object prdType = paramsMap.get("prdType");
        if (prdType != null) {
        	hql.append(" and prdType = ?");
        	params.add(prdType);
        }
        
        Object topName = paramsMap.get("topName");
        if (topName != null) {
        	hql.append(" and topName like ?");
        	params.add("%" + topName + "%");
        }
        
        Object status = paramsMap.get("status");
        if (status != null) {
        	hql.append(" and status = ?");
        	params.add(status);
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
		StringBuffer hql = new StringBuffer("select count(id) from TopRecommend where 1 = 1");
        List<Object> params = new ArrayList<Object>();
        
        Object id = paramsMap.get("id");
        if (id != null) {
        	hql.append(" and id = ?");
        	params.add(id);
        }
        
        Object topId = paramsMap.get("topId");
        if (topId != null) {
        	hql.append(" and topId = ?");
        	params.add(topId);
        }
        
        Object prdType = paramsMap.get("prdType");
        if (prdType != null) {
        	hql.append(" and prdType = ?");
        	params.add(prdType);
        }
        
        Object topName = paramsMap.get("topName");
        if (topName != null) {
        	hql.append(" and topName like ?");
        	params.add("%" + topName + "%");
        }
        
        Object status = paramsMap.get("status");
        if (status != null) {
        	hql.append(" and status = ?");
        	params.add(status);
        }
		return this.count(hql.toString(), params.toArray());
	}

	@Override
	public Boolean checkExist(Long topId,String prdType,String topName,Long id){
		StringBuffer hql = new StringBuffer("select count(id) from TopRecommend where topId = ? and prdType = ?  and topName = ?");
        List<Object> params = new ArrayList<Object>();
        params.add(topId);
        params.add(prdType);
        params.add(topName);
        if(id != null){
        	hql.append(" and id <> ?");
        	params.add(id);
        }        
		return this.count(hql.toString(),params.toArray()) > 0;
	}	
}
