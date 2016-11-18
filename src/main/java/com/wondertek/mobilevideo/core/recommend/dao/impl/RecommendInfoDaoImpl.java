package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.RecommendInfoDao;
import com.wondertek.mobilevideo.core.recommend.model.RecommendInfo;
import com.wondertek.mobilevideo.core.recommend.util.RecommendConstants;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class RecommendInfoDaoImpl extends GenericDaoHibernate<RecommendInfo,Long> implements RecommendInfoDao {
	public RecommendInfoDaoImpl() {
		super(RecommendInfo.class);
	}

	@Override
	public List<RecommendInfo> queryByLabels(String labelNames, String prdType, String catId) {
		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("from RecommendInfo where status = ? and prdType = ? and catId = ?");
		params.add(RecommendConstants.VALID);
		params.add(prdType);
		params.add(catId);
		
		int count = 0;
		sb.append(" and (");
		for(String labelName : labelNames.split(RecommendConstants.SPLIT_COMMA)){
			labelName = labelName.trim();
			if(!StringUtil.isNullStr(labelName)){
				if(count != 0){
					sb.append(" or ");
				}
				sb.append("labelInfo like ?");
				params.add("%" + RecommendConstants.SPLIT_COMMA + labelName + RecommendConstants.SPLIT_COMMA + "%");
				count++;
			}
		}
		sb.append(")");
		return this.query(sb.toString(),params.toArray());
	}

	@Override
	public List<RecommendInfo> queryAllAvailable() {
		return this.query("from RecommendInfo where status = ? order by updateTime desc,id desc", new Object[]{RecommendConstants.VALID});
	}

	@Override
	public List<RecommendInfo> getByParam(Map<String, Object> paramsMap, int start, int limit) {
		StringBuffer hql = new StringBuffer("from RecommendInfo where 1 = 1");
        List<Object> params = new ArrayList<Object>();
		Object id = paramsMap.get("id");
        if (id != null) {
        	hql.append(" and id = ?");
        	params.add(id);
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
        Object catId = paramsMap.get("catId");
        if (catId != null) {
        	hql.append(" and catId = ?");
        	params.add(catId);
        }
        Object prdContId = paramsMap.get("prdContId");
        if (prdContId != null) {
        	hql.append(" and prdContId = ?");
        	params.add(prdContId);
        }
        Object contName = paramsMap.get("contName");
        if (contName != null) {
        	hql.append(" and contName like ?");
        	params.add("%" + contName + "%");
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
		StringBuffer hql = new StringBuffer("select count(id) from RecommendInfo where 1 = 1");
        List<Object> params = new ArrayList<Object>();
        
        Object id = paramsMap.get("id");
        if (id != null) {
        	hql.append(" and id = ?");
        	params.add(id);
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
						count++;
					}
					hql.append("labelInfo like ?");
					params.add("%" + RecommendConstants.SPLIT_COMMA + labelName + RecommendConstants.SPLIT_COMMA + "%");
				}
			}
			hql.append(")");
        }
        Object prdType = paramsMap.get("prdType");
        if (prdType != null) {
        	hql.append(" and prdType = ?");
        	params.add(prdType);
        }
        Object catId = paramsMap.get("catId");
        if (catId != null) {
        	hql.append(" and catId = ?");
        	params.add(catId);
        }
        Object prdContId = paramsMap.get("prdContId");
        if (prdContId != null) {
        	hql.append(" and prdContId = ?");
        	params.add(prdContId);
        }
        Object contName = paramsMap.get("contName");
        if (contName != null) {
        	hql.append(" and contName like ?");
        	params.add("%" + contName + "%");
        }
        Object status = paramsMap.get("status");
        if (status != null) {
        	hql.append(" and status = ?");
        	params.add(status);
        }
        
		return this.count(hql.toString(), params.toArray());
	}

	@Override
	public Boolean checkExist(String prdType, String catId, Long prdContId, Long id) {
		StringBuffer hql = new StringBuffer("select count(id) from RecommendInfo where prdType = ? and catId = ? and prdContId = ?");
        List<Object> params = new ArrayList<Object>();
        params.add(prdType);
        params.add(catId);
        params.add(prdContId);
        if(id != null){
        	hql.append(" and id <> ?");
        	params.add(id);
        }
        
		return this.count(hql.toString(),params.toArray()) > 0;
	}
}
