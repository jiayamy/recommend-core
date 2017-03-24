package com.wondertek.mobilevideo.core.recommend.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchTest {
	private static String searchUrl = "http://221.181.100.37:8082/search/opensearch.msp";
	
	public static void main(String[] args) {
//		SearchRequest searchRequest = new SearchRequest();
////		searchRequest.setKeyword("(mediaJiabin:金星 AND mediaJiabin:金大川) OR mediaYear:2017");
////		searchRequest.setKeyword("mediaBaodaos:短讯 OR mediaYuyan:国语 OR mediaType:民生 OR mediaPlat:网络 OR mediaType:国内社会");
////		searchRequest.setFields("1008,1079");
//		searchRequest.setFields("");
//		searchRequest.setKeyword("priKeyword:连载");
//		searchRequest.setCt("101");
//		searchRequest.setCtVer("");
//		searchRequest.setPackId("1002601");
//		searchRequest.setContDisplayType("1007");	//一级分类
//		searchRequest.setMediaShape("");			//内容形态,全片、预告、精编、改编、花絮、资讯、专题、连载
//		searchRequest.setType("0");
//		searchRequest.setMediaArea("韩国");
//		searchRequest.setIsDebug("1");
//		searchRequest.setPageSize(""+100);
//		searchRequest.setPageStart("0");
//		searchRequest.setOrder("0");
//		
//		System.out.println(SearchUtil.httpRequest(searchUrl, searchRequest));
		
		System.out.println(new Date(1489975891758L));
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("1");
		System.out.println(list.toString().replace("[", "").replace("]", "").replaceAll(" ", ""));
	}

}
