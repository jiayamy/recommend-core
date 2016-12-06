package com.wondertek.mobilevideo.core.recommend.service;

import java.util.List;

import com.wondertek.mobilevideo.core.base.GenericManager;
import com.wondertek.mobilevideo.core.recommend.model.EnumsConfig;

public interface EnumsConfigService extends GenericManager<EnumsConfig,Long> {
	
	public List<EnumsConfig> findByType(String type);
	
	public List<EnumsConfig> findAll();
	
	public List<EnumsConfig> findByParent(String parent);
	
	/**
	 * 删除二级标签
	 * @param id
	 */
	public void deleteById(Long id);
	
	public Boolean checkExistLabel(String key,String parent,String type);
}
