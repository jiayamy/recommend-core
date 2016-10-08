package com.wondertek.mobilevideo.core.recommend.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.dao.PrdTypeRelationDao;
import com.wondertek.mobilevideo.core.recommend.model.PrdTypeRelation;

/**
 * 产品对应产品包缓存
 * @author lvliuzhong
 *
 */
public class PrdTypeRelationCache
{
	public static Boolean isHandling = Boolean.FALSE;
	private static Logger log = Logger.getLogger(PrdTypeRelationCache.class);
	
	public static Map<String,PrdTypeRelation> PRDTYPE_RELATIONS = new HashMap<String,PrdTypeRelation>();
	
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
		PrdTypeRelationDao prdTypeRelationDao = (PrdTypeRelationDao) Constants.ctx.getBean("prdTypeRelationDao");
		if(prdTypeRelationDao != null){
			Map<String,PrdTypeRelation> PRDTYPE_RELATION = new HashMap<String,PrdTypeRelation>();
			List<PrdTypeRelation> list = prdTypeRelationDao.getAll();
			if(list != null && !list.isEmpty()){
				for(PrdTypeRelation prdTypeRelation : list){
					PRDTYPE_RELATION.put(prdTypeRelation.getPrdType(), prdTypeRelation);
				}
			}
			Map<String,PrdTypeRelation> tmp = PRDTYPE_RELATIONS;
			PRDTYPE_RELATIONS = PRDTYPE_RELATION;
			tmp.clear();
		}
		if(log.isDebugEnabled()){
			for(String key : PRDTYPE_RELATIONS.keySet()){
				log.debug("initFromDb key:" + key + ",val:" + PRDTYPE_RELATIONS.get(key));
			}
			log.debug("initFromDb end");
		}
	}
}
