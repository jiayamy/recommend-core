package com.wondertek.mobilevideo.core.recommend.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.dao.SystemConfigDao;
import com.wondertek.mobilevideo.core.recommend.model.SystemConfig;
import com.wondertek.mobilevideo.core.recommend.util.RequestConstants;
import com.wondertek.mobilevideo.core.util.StringUtil;

/**
 * 系统配置项缓存
 * @author lvliuzhong
 *
 */
public class SystemConfigCache
{
	private static Logger log = Logger.getLogger(SystemConfigCache.class);

	private SystemConfigCache()
	{
	}

	private static Map<String, String> configs = new HashMap<String, String>();

	public static String getValue(String key)
	{
		return configs.get(key);
	}

	public static String getValueDefault(String key, String defValue)
	{
		return configs.get(key) == null ? defValue : configs.get(key);
	}

	public static int getIntValueDefault(String key, int defValue)
	{
		try
		{
			return Integer.parseInt(configs.get(key));
		} catch (Exception e)
		{
			return defValue;
		}
	}

	public static Double getDoubleValueDefault(String key, Double defValue)
	{
		try
		{
			return Double.parseDouble(configs.get(key));
		} catch (Exception e)
		{
			return defValue;
		}
	}
	
	public static int getIntValue(String key)
	{
		return getIntValueDefault(key, 0);
	}

	public static boolean containsConfig(String key)
	{
		return configs.containsKey(key);
	}

	public static void init(SystemConfigDao dao)
	{
		if(dao == null)
			dao = (SystemConfigDao) Constants.ctx.getBean("systemConfigDao");
		log.info("begin init System Config......");
		Map<String, String> temp = new HashMap<String, String>();
		List<SystemConfig> list = dao.getAll();
		for (SystemConfig config : list)
		{
			temp.put(config.getConfigKey(), config.getConfigValue());
		}
		configs = temp;
		
		//初始化参数
		initData();
		
		log.info("end init System Config , totals : " + configs.size());
	}
	
	private static void initData() {
		String sVal = getValue(RequestConstants.P_DEFAULT_USERTAG);
		if(!StringUtil.isNullStr(sVal)){
			RequestConstants.V_DEFAULT_USERTAG = sVal;
		}
		RequestConstants.V_DEFAULT_USERTAG_SCORE = getDoubleValueDefault(RequestConstants.P_DEFAULT_USERTAG_SCORE,10d);
		
		RequestConstants.V_DEFAUL_REQUEST_LIMIT = getIntValueDefault(RequestConstants.P_DEFAUL_REQUEST_LIMIT,10);
		
		RequestConstants.V_DEFAUL_REQUEST_TAG_CAT_MAX = getIntValueDefault(RequestConstants.P_DEFAUL_REQUEST_TAG_CAT_MAX,10);
		
		RequestConstants.V_DEFAUL_REQUEST_TAG_CATITEM_MAX = getIntValueDefault(RequestConstants.P_DEFAUL_REQUEST_TAG_CATITEM_MAX,10);
		
		RequestConstants.V_DEFAUL_REQUEST_TAG_RECOMD_MAX = getIntValueDefault(RequestConstants.P_DEFAUL_REQUEST_TAG_RECOMD_MAX,10);
		
//		RequestConstants.V_DEFAULT_SEARCH_COUNT_MAX = getIntValueDefault(RequestConstants.P_DEFAULT_SEARCH_COUNT_MAX,100);
		
		RequestConstants.V_PRINT_REQUEST_ENABLE = StringUtil.nullToBoolean(getValue(RequestConstants.P_PRINT_REQUEST_ENABLE));
		
		sVal = getValue(RequestConstants.P_SEARCH_URL);
		if(!StringUtil.isNullStr(sVal)){
			RequestConstants.V_SEARCH_URL = sVal;
		}
		
		RequestConstants.V_SEARCH_RECOMD_ENABLE = StringUtil.nullToBoolean(getValue(RequestConstants.P_SEARCH_RECOMD_ENABLE));
		
		RequestConstants.V_DEFAULT_SEARCH_ENABLE = StringUtil.nullToBoolean(getValue(RequestConstants.P_DEFAULT_SEARCH_ENABLE));
		
		RequestConstants.V_DEFAULT_SEARCH_LIMIT = getIntValueDefault(RequestConstants.P_DEFAULT_SEARCH_LIMIT,20);
		
		RequestConstants.V_DEFAULT_SEARCH_LIMIT_CATITEM = getIntValueDefault(RequestConstants.P_DEFAULT_SEARCH_LIMIT_CATITEM,5);
		
		RequestConstants.V_DEFAULT_SEARCH_CAT_MAX = getIntValueDefault(RequestConstants.P_DEFAULT_SEARCH_CAT_MAX,3);
		
//		RequestConstants.V_DEFAULT_SEARCH_CAT_PER_MAX = getIntValueDefault(RequestConstants.P_DEFAULT_SEARCH_CAT_PER_MAX,2);
		
		RequestConstants.V_DEFAULT_SEARCH_CATITEM_MAX = getIntValueDefault(RequestConstants.P_DEFAULT_SEARCH_CATITEM_MAX,5);
		
		RequestConstants.V_DEFAULT_RECOMD_CAT_MAX = getIntValueDefault(RequestConstants.P_DEFAULT_RECOMD_CAT_MAX,5);
		
		RequestConstants.V_DEFAULT_RECOMD_CATITEM_MAX = getIntValueDefault(RequestConstants.P_DEFAULT_RECOMD_CATITEM_MAX,10);
		
		RequestConstants.V_DEFAULT_RECOMD_SPECIALTOPIC_RATIO = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_SPECIALTOPIC_RATIO,0d);
		if(RequestConstants.V_DEFAULT_RECOMD_SPECIALTOPIC_RATIO < 0){
			RequestConstants.V_DEFAULT_RECOMD_SPECIALTOPIC_RATIO = 0d;
		}
		RequestConstants.V_DEFAULT_RECOMD_COMBINEDCONT_RATIO = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_COMBINEDCONT_RATIO,0d);
		if(RequestConstants.V_DEFAULT_RECOMD_COMBINEDCONT_RATIO < 0){
			RequestConstants.V_DEFAULT_RECOMD_COMBINEDCONT_RATIO = 0d;
		}
		RequestConstants.V_DEFAULT_RECOMD_BIGPICCONT_RATIO = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_BIGPICCONT_RATIO,0d);
		if(RequestConstants.V_DEFAULT_RECOMD_BIGPICCONT_RATIO < 0){
			RequestConstants.V_DEFAULT_RECOMD_BIGPICCONT_RATIO = 0d;
		}
		RequestConstants.V_DEFAULT_RECOMD_MULTIPICCONT_RATIO = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_MULTIPICCONT_RATIO,0d);
		if(RequestConstants.V_DEFAULT_RECOMD_MULTIPICCONT_RATIO < 0){
			RequestConstants.V_DEFAULT_RECOMD_MULTIPICCONT_RATIO = 0d;
		}
		RequestConstants.V_DEFAULT_RECOMD_TAG_CAT_WEIGHT = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_TAG_CAT_WEIGHT,100d);
		if(RequestConstants.V_DEFAULT_RECOMD_TAG_CAT_WEIGHT < 0){
			RequestConstants.V_DEFAULT_RECOMD_TAG_CAT_WEIGHT = 100d;
		}
		RequestConstants.V_DEFAULT_RECOMD_TAG_ITEM_WEIGHT = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_TAG_ITEM_WEIGHT,100d);
		if(RequestConstants.V_DEFAULT_RECOMD_TAG_ITEM_WEIGHT < 0){
			RequestConstants.V_DEFAULT_RECOMD_TAG_ITEM_WEIGHT = 100d;
		}
		RequestConstants.V_DEFAULT_RECOMD_TAG_RCMDITEM_WEIGHT = getDoubleValueDefault(RequestConstants.P_DEFAULT_RECOMD_TAG_RCMDITEM_WEIGHT,100d);
		if(RequestConstants.V_DEFAULT_RECOMD_TAG_RCMDITEM_WEIGHT < 0){
			RequestConstants.V_DEFAULT_RECOMD_TAG_RCMDITEM_WEIGHT = 100d;
		}
	}

	public static Map<String, String> getAllConfigs()
	{
		return configs ;
	}
}
