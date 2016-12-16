package com.wondertek.mobilevideo.core.recommend.vo;

import org.apache.struts2.json.annotations.JSON;

import com.wondertek.mobilevideo.core.base.BaseObject;

public class RecommendParam extends BaseObject{

	private static final long serialVersionUID = -2767803538211540196L;
	
	private String text;
	
	private String iconCls;
	
	private Boolean isParent;
	
	
	private String laberType;
	
	private String weight;
	
	private Long id;
	
	private String parentText;
	
	private String parentId;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	public String getLaberType() {
		return laberType;
	}

	public void setLaberType(String laberType) {
		this.laberType = laberType;
	}
	
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@JSON(name = "nodeId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentText() {
		return parentText;
	}

	public void setParentText(String parentText) {
		this.parentText = parentText;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iconCls == null) ? 0 : iconCls.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isParent == null) ? 0 : isParent.hashCode());
		result = prime * result + ((laberType == null) ? 0 : laberType.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((parentText == null) ? 0 : parentText.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		RecommendParam other = (RecommendParam) obj;
		if (iconCls == null) {
			if (other.iconCls != null)
				return false;
		} else if (!iconCls.equals(other.iconCls))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isParent == null) {
			if (other.isParent != null)
				return false;
		} else if (!isParent.equals(other.isParent))
			return false;
		if (laberType == null) {
			if (other.laberType != null)
				return false;
		} else if (!laberType.equals(other.laberType))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (parentText == null) {
			if (other.parentText != null)
				return false;
		} else if (!parentText.equals(other.parentText))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecommendParam [text=" + text + ", iconCls=" + iconCls + ", isParent=" + isParent + ", laberType="
				+ laberType + ", weight=" + weight + ", id=" + id + ", parentText=" + parentText + ", parentId="
				+ parentId + "]";
	}


}
