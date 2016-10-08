package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.bean.ParamBean;
import com.wondertek.mobilevideo.core.recommend.bean.ResultBean;
import com.wondertek.mobilevideo.core.recommend.dao.SystemConfigDao;
import com.wondertek.mobilevideo.core.recommend.model.SystemConfig;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class SystemConfigDaoImpl extends GenericDaoHibernate<SystemConfig,Long> implements SystemConfigDao {
	
	public SystemConfigDaoImpl() {
		super(SystemConfig.class);
	}
	
	@Override
	public SystemConfig querySystemConfig(String key) {
		ResultBean result = queryConfigList(null);
		List<SystemConfig> list= (List<SystemConfig>)result.getReturnObject();
		for (SystemConfig config : list) {
			if (config.getConfigKey().equals(key)) {
				return config;
			}
		}
		return new SystemConfig();
	}
	
	@Override
	public ResultBean queryConfigList(ParamBean params) {
		ResultBean result = new ResultBean();
		long total = count("select count(id) from SystemConfig");
		if (total > 0) {
			result.setReturnObject(query("from SystemConfig order by configKey"));
		}
		return result.setTotal(total);
	}
	
	@Override
	public boolean updateConfig(SystemConfig sys) {
		execute("update SystemConfig set configName=?,configValue=?,detail=? where id=?",new Object[]{sys.getConfigValue(),sys.getDetail(),sys.getId()});
		return true;
	}
	
	@Override
	public Long getConfigCount(Map<String, Object> paramsMap) {
        StringBuffer hql = new StringBuffer("select count(id) from SystemConfig where 1 = 1 ");
        List<Object> params = new ArrayList<Object>();
        
        String configKey = (String)paramsMap.get("configKey");
        if (configKey != null && configKey.length() > 0) {
        	hql.append(" and configKey like ? ");
        	params.add("%" + configKey + "%");
        }
        
        String configValue = (String)paramsMap.get("configValue");
        if (configValue != null && configValue.length() > 0) {
        	hql.append(" and configValue like ? ");
        	params.add("%" + configValue + "%");
        }
		return this.count(hql.toString(), params.toArray());
	}

	@Override
	public List<SystemConfig> getConfigList(Map<String, Object> paramsMap, int start, int limit) {
        StringBuffer hql = new StringBuffer("from SystemConfig where 1 = 1");
        List<Object> params = new ArrayList<Object>();
        
        String configKey = (String)paramsMap.get("configKey");
        if (configKey != null && configKey.length() > 0) {
        	hql.append(" and configKey like ? ");
        	params.add("%" + configKey + "%");
        }
        
        String configValue = (String)paramsMap.get("configValue");
        if (configValue != null && configValue.length() > 0) {
        	hql.append(" and configValue like ? ");
        	params.add("%" + configValue + "%");
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
	public SystemConfig getConfigByKey(String configKey) {
		String hql = "from SystemConfig where configKey = ?";
		List<SystemConfig> list = this.query(hql, new Object[]{ configKey });
		
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Boolean isExistConfig(String key) {
		String hql = "select count(id) from SystemConfig where configKey = ?";
		return this.count(hql, key) > 0;
	}
	
}
