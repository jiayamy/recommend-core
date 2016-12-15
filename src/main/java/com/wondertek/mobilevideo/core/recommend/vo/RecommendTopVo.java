package com.wondertek.mobilevideo.core.recommend.vo;

import java.io.Serializable;

public class RecommendTopVo implements Serializable {	
	private static final long serialVersionUID = -6607618405340207571L;
	
	private Long topId;
	
	private String topName;
	
	public Long getTopId() {
		return topId;
	}
	public void setTopId(Long topId) {
		this.topId = topId;
	}
	
	public String getTopName() {
		return topName;
	}
	public void setTopName(String topName) {
		this.topName = topName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topId == null) ? 0 : topId.hashCode());
		result = prime * result + ((topName == null) ? 0 : topName.hashCode());
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
		RecommendTopVo other = (RecommendTopVo) obj;
		if (topId == null) {
			if (other.topId != null)
				return false;
		} else if (!topId.equals(other.topId))
			return false;
		if (topName == null) {
			if (other.topName != null)
				return false;
		} else if (!topName.equals(other.topName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RecommendTopVo [topId=" + topId + ", topName=" + topName + "]";
	}
	
}
