package com.wondertek.mobilevideo.core.recommend.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 请求参数
 * @author lvliuzhong
 */
public class ParamBean {
	/**
	 * 输入对象
	 */
	private Object inputObject;
	/**
	 * 输入对象集合
	 */
	private List<Object> inputList = new ArrayList<Object>(10);
	/**
	 * 结果集索引开始位置
	 */
	private int start;
	/**
	 * 结果集数量限制
	 */
	private int limit = 50;
	/**
	 * 结果集页数
	 */
	private int page;
	/**
	 * 排序信息对象
	 */
	private SortBean sortBean;
	
	/**
	 * 根据参数索引获取参数对象
	 * @param i
	 * @return
	 */
	public Object getParam(int i) {
		return getInputList().get(i);	
	}
	public List<Object> getInputList() {
		return inputList == null ? new ArrayList<Object>(10) : inputList;
	}
	public ParamBean setInputList(List<Object> inputList) {
		this.inputList = inputList;
		return this;
	}
	public ParamBean addInputObject(Object obj) {
		getInputList().add(obj);
		return this;
	}
	public ParamBean addInputObject(int postion,Object obj) {
		getInputList().set(postion,obj);
		return this;
	}
	
	public SortBean getSortBean() {
		return sortBean;
	}
	
	public ParamBean setSortBean(SortBean sortBean) {
		this.sortBean = sortBean;
		return this;
	}
	
	public int getPage() {
		return page;
	}
	public ParamBean setPage(int page) {
		this.page = page;
		return this;
	}
	public Object getInputObject() {
		return inputObject;
	}
	public ParamBean setInputObject(Object inputObject) {
		this.inputObject = inputObject;
		return this;
	}
	public int getStart() {
		return start;
	}
	public ParamBean setStart(int start) {
		this.start = start;
		return this;
	}
	public int getLimit() {
		return limit;
	}
	public ParamBean setLimit(int limit) {
		this.limit = limit;
		return this;
	}
}
