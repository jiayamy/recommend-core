package com.wondertek.mobilevideo.core.recommend.servlet;

import org.apache.commons.httpclient.NameValuePair;
import org.junit.Test;

import com.wondertek.mobilevideo.core.recommend.BaseTestCase;
import com.wondertek.mobilevideo.core.util.HttpClientUtil;

public class DistPlayBillResponseTest extends BaseTestCase {
	private String url = "http://127.0.0.1:8080/mam-admin/distPlayBillRespServlet";
	private String channelId = "5100002031";
	private NameValuePair[] nvp = new NameValuePair[0];
	/*private String resultMessage = "成功";
	private String resultCode = "000000";*/
	private String resultMessage = "失败";
	private String resultCode = "000001";
	
	@Test
	public void testDoPost() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"contentId\":\"").append(channelId).append("\",");
		sb.append("\"resultCode\":\"").append(resultCode).append("\",");
		sb.append("\"resultMessage\":\"").append(resultMessage).append("\"");
		sb.append("}");
		
		String response = HttpClientUtil.httpClientPost(url, nvp, sb.toString());
		System.out.println("======响应为" + response);
	}
}
