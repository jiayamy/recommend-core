package com.wondertek.mobilevideo.core.recommend.bean;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * 业务执行结果对象
 * @author lvliuzhong
 */
public class ResultBean {
	/** * 执行结果	 */
	private boolean success = false;
	
	/** * 执行返回结果	 */
	private Object returnObject;
	/** * 执行结果集	 */
	private List<?> returnSet;
	/** * 执行结果集	 */
	private long total;
	
	/** * 执行错误描述	 */
	private String errorMessage;
	/** * 描述信息	 */
	private String msg;
	/** * 描述信息集合	 */
	private String[] msgList;
	
	public String[] getMsgList() {
		return msgList;
	}
	public ResultBean setMsgList(String[] msgList) {
		this.msgList = msgList;
		return this;
	}
	public List<?> getReturnSet() {
		return returnSet;
	}
	public ResultBean setReturnSet(List<?> returnSet) {
		this.returnSet = returnSet;
		return this;
	}
	public long getTotal() {
		return total;
	}
	public ResultBean setTotal(long total) {
		this.total = total;
		return this;
	}
	public Object getReturnObject() {
		return returnObject;
	}
	public ResultBean setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
		return this;
	}
	public boolean isSuccess() {
		return success;
	}
	public ResultBean setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ResultBean setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public ResultBean setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public String getReturnJson() {
		return "{\"root\":" + JSON.toJSONString(getReturnObject(),SerializerFeature.WriteDateUseDateFormat)
			+ ",\"total\":" + getTotal() + "}";
	}
}
