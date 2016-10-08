package com.wondertek.mobilevideo.core.recommend.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.dao.EnumsInfoDao;
import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;

/**
 * 枚举值缓存
 * @author lvliuzhong
 *
 */
public class EnumsInfoCache
{
	public static Boolean isHandling = Boolean.FALSE;
	private static Logger log = Logger.getLogger(EnumsInfoCache.class);
	public static final int TYPE_CAT = 0;
	public static final int TYPE_LABEL = 1;
	public static Map<Integer,Map<String,String>> VAL_ENUMSINFO = new HashMap<Integer,Map<String,String>>();
	
	public static void init() {
		if(isHandling){
			return;
		}
		isHandling = Boolean.TRUE;
		initFromDb();
		isHandling = Boolean.FALSE;
	}

	private static void initFromDb() {
		if(log.isDebugEnabled())
			log.debug("initFromDb start");
		EnumsInfoDao enumsInfoDao = (EnumsInfoDao) Constants.ctx.getBean("enumsInfoDao");
		if(enumsInfoDao != null){
			Map<Integer,Map<String,String>> tmp = new HashMap<Integer,Map<String,String>>();
			List<EnumsInfo> list = enumsInfoDao.getAll();
			if(list != null && !list.isEmpty()){
				for(EnumsInfo enumsInfo : list){
					if(!tmp.containsKey(enumsInfo.getType())){
						tmp.put(enumsInfo.getType(), new HashMap<String,String>());
					}
					tmp.get(enumsInfo.getType()).put(enumsInfo.getVal(), enumsInfo.getKey());
				}
			}
			VAL_ENUMSINFO = tmp;
		}
		if(log.isDebugEnabled()){
			for(Integer key : VAL_ENUMSINFO.keySet()){
				log.debug("initFromDb key:" + key + ",size:" + VAL_ENUMSINFO.get(key).size());
			}
			log.debug("initFromDb end");
		}
	}
}
