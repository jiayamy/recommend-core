package com.wondertek.mobilevideo.core.recommend.util;

public class RequestConstants {
	/**
	 * 用户默认标签
	 */
	public static final String P_DEFAULT_USERTAG = "user.tag.default";
	public static String V_DEFAULT_USERTAG;
	/**
	 * 用户标签默认分数
	 */
	public static final String P_DEFAULT_USERTAG_SCORE = "user.tag.score.default";
	public static Double V_DEFAULT_USERTAG_SCORE = 10d;
	/**
	 * 请求默认每页条数
	 */
	public static final String P_DEFAUL_REQUEST_LIMIT = "request.default.limit";
	public static int V_DEFAUL_REQUEST_LIMIT = 10;
	/**
	 * 请求用户标签时一级分类的最大个数
	 */
	public static final String P_DEFAUL_REQUEST_TAG_CAT_MAX = "request.default.tag.cat.max";
	public static int V_DEFAUL_REQUEST_TAG_CAT_MAX = 10;
	/**
	 * 请求用户标签时一级分类下的普通标签最大个数
	 */
	public static final String P_DEFAUL_REQUEST_TAG_CATITEM_MAX = "request.default.tag.catitem.max";
	public static int V_DEFAUL_REQUEST_TAG_CATITEM_MAX = 10;
	/**
	 * 请求用户标签时一级分类下的推荐标签最大个数
	 */
	public static final String P_DEFAUL_REQUEST_TAG_RECOMD_MAX = "request.default.tag.recomd.max";
	public static int V_DEFAUL_REQUEST_TAG_RECOMD_MAX = 10;
	/**
	 * 正常调用请求最多查询多少条记录进行分页
	 * @deprecated
	 */
	public static final String P_DEFAULT_SEARCH_COUNT_MAX = "search.default.count.max";
	public static int V_DEFAULT_SEARCH_COUNT_MAX = 100;
	/**
	 * 打印返回大数据
	 */
	public static final String P_PRINT_REQUEST_ENABLE = "print.request.enable";
	public static Boolean V_PRINT_REQUEST_ENABLE = Boolean.TRUE;
	/**
	 * 搜索请求地址
	 */
	public static final String P_SEARCH_URL = "search.url";
	public static String V_SEARCH_URL;
	/**
	 * 搜索时，带推荐标签
	 */
	public static final String P_SEARCH_RECOMD_ENABLE = "search.recomd.enable";
	public static Boolean V_SEARCH_RECOMD_ENABLE = Boolean.TRUE;
	
	/**
	 * 调用搜索引擎时，查询一次一级分类最多查询多少条记录
	 */
	public static final String P_DEFAULT_SEARCH_ENABLE = "search.default.enable";
	public static Boolean V_DEFAULT_SEARCH_ENABLE = Boolean.TRUE;
	/**
	 * 调用搜索引擎时，查询一次一级分类最多查询多少条记录
	 */
	public static final String P_DEFAULT_SEARCH_LIMIT = "search.default.limit";
	public static int V_DEFAULT_SEARCH_LIMIT = 20;
	/**
	 * 调用搜索引擎时，查询一次一级分类下的固定标签最多查询多少条记录
	 * @deprecated
	 */
	public static final String P_DEFAULT_SEARCH_LIMIT_CATITEM = "search.default.limit.catItem";
	public static int V_DEFAULT_SEARCH_LIMIT_CATITEM = 5;
	/**
	 * 调用搜索引擎时，最多查询多少个一级分类
	 */
	public static final String P_DEFAULT_SEARCH_CAT_MAX = "search.default.cat.max";
	public static int V_DEFAULT_SEARCH_CAT_MAX = 3;
	/**
	 * 调用搜索引擎时，查询一次一级分类最多分多少次查询
	 * @deprecated
	 */
	public static final String P_DEFAULT_SEARCH_CAT_PER_MAX = "search.default.cat.per.max";
	public static int V_DEFAULT_SEARCH_CAT_PER_MAX = 2;
	/**
	 * 调用搜索引擎时，最多查询多少个一级分类下的标签
	 */
	public static final String P_DEFAULT_SEARCH_CATITEM_MAX = "search.default.catitem.max";
	public static int V_DEFAULT_SEARCH_CATITEM_MAX = 5;
	/**
	 * 人工推荐时，最多查询多少个一级分类
	 */
	public static final String P_DEFAULT_RECOMD_CAT_MAX = "recomd.default.cat.max";
	public static int V_DEFAULT_RECOMD_CAT_MAX = 5;
	/**
	 * 人工推荐时，最多查询多少个一级分类下推荐标签
	 */
	public static final String P_DEFAULT_RECOMD_CATITEM_MAX = "recomd.default.catitem.max";
	public static int V_DEFAULT_RECOMD_CATITEM_MAX = 10;
	/**
	 * 综合推荐时，专题推荐比例，只可为正小数，否则为0，如0.02
	 */
	public static final String P_DEFAULT_RECOMD_SPECIALTOPIC_RATIO = "recomd.default.specialTopic.ratio";
	public static Double V_DEFAULT_RECOMD_SPECIALTOPIC_RATIO = 0d;
	/**
	 * 综合推荐时，组合内容推荐比例，只可为正小数，否则为0，如0.02
	 */
	public static final String P_DEFAULT_RECOMD_COMBINEDCONT_RATIO = "recomd.default.combinedCont.ratio";
	public static Double V_DEFAULT_RECOMD_COMBINEDCONT_RATIO = 0d;
	/**
	 * 综合推荐时，大图内容推荐比例，只可为正小数，否则为0，如0.02
	 */
	public static final String P_DEFAULT_RECOMD_BIGPICCONT_RATIO = "recomd.default.bigPicCont.ratio";
	public static Double V_DEFAULT_RECOMD_BIGPICCONT_RATIO = 0d;
	/**
	 * 综合推荐时，多图内容推荐比例，只可为正小数，否则为0，如0.02
	 */
	public static final String P_DEFAULT_RECOMD_MULTIPICCONT_RATIO = "recomd.default.multiPicCont.ratio";
	public static Double V_DEFAULT_RECOMD_MULTIPICCONT_RATIO = 0d;
	/**
	 * 推荐时，一级标签默认权重
	 */
	public static final String P_DEFAULT_RECOMD_TAG_CAT_WEIGHT = "recomd.default.tag.cat.weight";
	public static Double V_DEFAULT_RECOMD_TAG_CAT_WEIGHT = 100d;
	/**
	 * 推荐时，普通标签默认权重
	 */
	public static final String P_DEFAULT_RECOMD_TAG_ITEM_WEIGHT = "recomd.default.tag.item.weight";
	public static Double V_DEFAULT_RECOMD_TAG_ITEM_WEIGHT = 100d;
	/**
	 * 推荐时，推荐标签默认权重
	 */
	public static final String P_DEFAULT_RECOMD_TAG_RCMDITEM_WEIGHT = "recomd.default.tag.rcmditem.weight";
	public static Double V_DEFAULT_RECOMD_TAG_RCMDITEM_WEIGHT = 100d;
	
	
	public static final String MAP_KEY_PREFIX_CAT = "1_";
	public static final String MAP_KEY_PREFIX_CAT_LABEL = "2_";
	public static final String MAP_KEY_PREFIX_RECOMMEND = "3_";
	
	public static final String SEARCH_KEY_RECOMMD = "1081";
	public static final String SEARCH_KEY_MEDIASHAPE = "1039";
	
	public static final String R_SUCC = "success";
	public static final String R_CODE = "returnCode";
	public static final String R_MSG = "returnMsg";
	public static final String R_ROOT = "root";
	public static final String R_POMS_CONT = "pomsCont";
	public static final String R_VOMS_SPECIALTOPIC = "specialTopic";
	public static final String R_VOMS_COMBINEDCONT = "combinedCont";
	public static final String R_VOMS_BIGPICCONT = "bigPicCont";
	public static final String R_VOMS_MULTIPICCONT = "multiPicCont";
	public static final String R_TOTAL = "total";
	public static final String R_TOTAL_SPECIALTOPIC = "specialTopicTotal";
	public static final String R_TOTAL_COMBINEDCONT = "combinedContTotal";
	public static final String R_TOTAL_BIGPICCONT = "bigPicContTotal";
	public static final String R_TOTAL_MULTIPICCONT = "multiPicContTotal";
	public static final String R_VOMS_REQUESTTIME = "requestTime";
	
	/**	 * 成功	 */
	public static final String R_CODE_000000 = "000000";
	/**
	 * 11开头与请求相关
	 * 请求体为空
	 */
	public static final String R_CODE_110001 = "110001";
	/**
	 * 请求体为与要求不符
	 */
	public static final String R_CODE_110002 = "110002";
	/**
	 * 必填参数为空
	 */
	public static final String R_CODE_110003 = "110003";
	/**
	 * 未找到对应的产品
	 */
	public static final String R_CODE_120001 = "120001";
	/**
	 * 用户标签为空
	 */
	public static final String R_CODE_120002 = "120002";
	/**
	 * 系统异常
	 */
	public static final String R_CODE_999999 = "999999";
}
