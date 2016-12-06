package com.wondertek.mobilevideo.core.recommend.model;

import com.wondertek.mobilevideo.core.base.BaseObject;

public class RecommendParam extends BaseObject{

	private static final long serialVersionUID = -2767803538211540196L;
	
	private String text;
	
	private String type;
	
	private AdditionalParameters additionalParameters;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AdditionalParameters getAdditionalParameters() {
		return additionalParameters;
	}

	public void setAdditionalParameters(AdditionalParameters additionalParameters) {
		this.additionalParameters = additionalParameters;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecommendParam [text=" + text + ", type=" + type + "]";
	}

}
