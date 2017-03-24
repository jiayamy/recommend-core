package com.wondertek.mobilevideo.core.recommend.vo.mongo;

import java.io.Serializable;

import org.msgpack.annotation.Message;

@Message
public class CatItem implements Serializable {
	private static final long serialVersionUID = -3629215418685364236L;
	
	public String labelName;
	public String labelId;		//标签
	public String labelKey;		//标签英文
	public String labelValue;	//
	public Double score;
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getLabelValue() {
		return labelValue;
	}
	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getLabelId() {
		return labelId;
	}
	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}
	public String getLabelKey() {
		return labelKey;
	}
	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labelId == null) ? 0 : labelId.hashCode());
		result = prime * result + ((labelKey == null) ? 0 : labelKey.hashCode());
		result = prime * result + ((labelName == null) ? 0 : labelName.hashCode());
		result = prime * result + ((labelValue == null) ? 0 : labelValue.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		CatItem other = (CatItem) obj;
		if (labelId == null) {
			if (other.labelId != null)
				return false;
		} else if (!labelId.equals(other.labelId))
			return false;
		if (labelKey == null) {
			if (other.labelKey != null)
				return false;
		} else if (!labelKey.equals(other.labelKey))
			return false;
		if (labelName == null) {
			if (other.labelName != null)
				return false;
		} else if (!labelName.equals(other.labelName))
			return false;
		if (labelValue == null) {
			if (other.labelValue != null)
				return false;
		} else if (!labelValue.equals(other.labelValue))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CatItem [labelName=" + labelName + ", labelId=" + labelId + ", labelKey=" + labelKey + ", labelValue="
				+ labelValue + ", score=" + score + "]";
	}
}
