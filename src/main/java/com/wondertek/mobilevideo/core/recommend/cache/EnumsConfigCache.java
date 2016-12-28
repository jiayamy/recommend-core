package com.wondertek.mobilevideo.core.recommend.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsConfigDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsConfig;

/**
 * 推荐权重缓存
 * @author Administrator
 *
 */
public class EnumsConfigCache {

	public static Boolean isHandling = Boolean.FALSE;
	private static Logger log = Logger.getLogger(EnumsConfigCache.class);
	public static Map<String,Double> ENUMS_CONFIG = new HashMap<String,Double>();
	
	public static void init() {
		if(isHandling){
			return;
		}
		isHandling = Boolean.TRUE;
		initFromDb();
		isHandling = Boolean.FALSE;
	}
	
	private static void initFromDb(){
		if(log.isDebugEnabled())
			log.debug("initFromDb start");
		EnumsConfigDao enumsConfigDao = (EnumsConfigDao)Constants.ctx.getBean("enumsConfigDao");
		if(enumsConfigDao != null){
			Map<String,Double> tmp = new HashMap<String,Double>();
			List<EnumsConfig> list = enumsConfigDao.findAll();
			if(list != null && !list.isEmpty()){
				for(EnumsConfig ec:list){
					if("0".equals(ec.getType())){
						tmp.put(ec.getKey(), Double.valueOf(ec.getWeight()));
					}else{
						tmp.put(ec.getParent()+"_"+ec.getKey(), Double.valueOf(ec.getWeight()));
					}
				}
			}
			ENUMS_CONFIG = tmp;
		}
		if(log.isDebugEnabled()){
			for(String key : ENUMS_CONFIG.keySet()){
				log.debug("initFromDb key:" + key + ",val:" + ENUMS_CONFIG.get(key));
			}
			log.debug("initFromDb end");
		}
	}
}
