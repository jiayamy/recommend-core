package com.wondertek.mobilevideo.core.recommend.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.wondertek.mobilevideo.core.recommend.util.RequestConstants;
import com.wondertek.mobilevideo.core.util.Md5Util;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class SearchUtil {
	private static final Logger log = Logger.getLogger(SearchUtil.class);
	
	public final static String S_VERTICALLINE = "|"; 
	
	public static String getSearchKey(SearchRequest request){
		//请求搜索引擎第一次
		String keys = S_VERTICALLINE + StringUtil.null2Str(request.getCt()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getCtVer()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getUa()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getType()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getKeyword()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getCoreName()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getFields()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getPackId()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getContDisplayType()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getMediaShape()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getPageSize()); 
		keys += S_VERTICALLINE + StringUtil.null2Str(request.getPageStart()); 
		keys += S_VERTICALLINE + (StringUtil.isNullStr(request.getOrder()) ? "1" : StringUtil.null2Str(request.getOrder())); 
		
		if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
			log.debug("Search keys :" + keys); 
		}
		return Md5Util.md5Code(keys);
	}
	public static List<SearchResult> httpRequest(String httpUrl, SearchRequest request) {
		if(!RequestConstants.V_DEFAULT_SEARCH_ENABLE){
			return null;
		}
		List<NameValuePair[]> list = new ArrayList<NameValuePair[]>();
		NameValuePair[] optIdValues = getNameValuePairs(request);
		list.add(optIdValues);
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String xml = httpClientUtil.httpClientPost(httpUrl, list);
		if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
			log.debug("search result:" + xml);
		}
		if(StringUtil.isNullStr(xml) && RequestConstants.V_DEFAULT_SEARCH_AGAIN_AFTERFAIL){//超时，是否再连一次
			xml = httpClientUtil.httpClientPost(httpUrl, list);
			if(log.isDebugEnabled() && RequestConstants.V_PRINT_REQUEST_ENABLE){
				log.debug("search result:" + xml);
			}
		}
		return pomsParserXML(request,xml);
	}

	private static NameValuePair[] getNameValuePairs(SearchRequest request) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		//参数
		if(request.getCt() != null && !"".equals(request.getCt())){
			list.add(new NameValuePair("ct", request.getCt()));
		}
		if(request.getCtVer() != null && !"".equals(request.getCtVer())){
			list.add(new NameValuePair("ctVer", request.getCtVer()));
		}
		if(request.getUa() != null && !"".equals(request.getUa())){
			list.add(new NameValuePair("ua", request.getUa()));
		}
		list.add(new NameValuePair("type", request.getType()));
		list.add(new NameValuePair("keyword", request.getKeyword()));
		list.add(new NameValuePair("coreName", request.getCoreName()));
		if(request.getFields() != null && !"".equals(request.getFields())){
			list.add(new NameValuePair("fields", request.getFields()));
		}
		if(request.getPackId() != null && !"".equals(request.getPackId())){
			list.add(new NameValuePair("packId", request.getPackId()));
		}
		if(request.getContDisplayType() != null && !"".equals(request.getContDisplayType())){
			list.add(new NameValuePair("contDisplayType", request.getContDisplayType()));
		}
		if(request.getMediaShape() != null && !"".equals(request.getMediaShape())){
			list.add(new NameValuePair("mediaShape", request.getMediaShape()));
		}
		//排序相关
		if(request.getPageSize() != null && !"".equals(request.getPageSize())){
			list.add(new NameValuePair("pageSize", request.getPageSize()));
		}
		if(request.getPageStart() != null && !"".equals(request.getPageStart())){
			list.add(new NameValuePair("pageStart", request.getPageStart()));
		}
		if(request.getOrder() != null && !"".equals(request.getOrder())){
			list.add(new NameValuePair("order", request.getOrder()));
		}else{
			list.add(new NameValuePair("order", "1"));
		}
		NameValuePair[] arr = new NameValuePair[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	private static List<SearchResult> pomsParserXML(SearchRequest request, String xml) {
		List<SearchResult> searchResult = new ArrayList<SearchResult>();
		try {
			if(StringUtil.isNullStr(xml)){
				return searchResult;
			}
			System.out.println(xml);
			Document doc = null;
			try {
				doc = DocumentHelper.parseText(xml);
			} catch (Exception e) {
			}
			if (doc != null) {
				Node rootNode = doc.selectSingleNode("//RESULT/searchResults");
				if (rootNode != null) {
//					resultMap.put("count", rootNode.valueOf("@count"));
//					resultMap.put("pageSize", rootNode.valueOf("@pageSize"));
					List xmlList = doc.selectNodes("//RESULT/searchResults/searchResult");
					for (Object nodeObj : xmlList) {
						SearchResult resultItem = new SearchResult();
						Element node = (Element) nodeObj;
						resultItem.setContentId(node.elementText("searchId"));
						resultItem.setContName(node.elementText("contName"));
						resultItem.setScore(StringUtil.nullToDouble(node.elementText("score")));
						searchResult.add(resultItem);
					}
//					resultMap.put("searchResult", searchResult);
//					//设置cacheTime
//					resultMap.put("cacheTime", new Date());
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return searchResult;
	}
}
