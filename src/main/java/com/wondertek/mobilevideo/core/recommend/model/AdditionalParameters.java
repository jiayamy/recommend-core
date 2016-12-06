package com.wondertek.mobilevideo.core.recommend.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.wondertek.mobilevideo.core.base.BaseObject;

public class AdditionalParameters extends BaseObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4303688278054001196L;
	
	/**
	 * 子节点列表
	 */
	private List<RecommendParam> children = new ArrayList<RecommendParam>();
	
	/**
	 * 节点id
	 */
	private String id;
	
	/**
	 * 是否被选中
	 */
	private boolean itemSelected;

	public List<RecommendParam> getChildren() {
		return children;
	}

	public void setChildren(List<RecommendParam> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@JSON(name="item-selected")
	public boolean isItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(boolean itemSelected) {
		this.itemSelected = itemSelected;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (itemSelected ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdditionalParameters other = (AdditionalParameters) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemSelected != other.itemSelected)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdditionalParameters [children=" + children + ", id=" + id + ", itemSelected=" + itemSelected + "]";
	}
	
	
}
