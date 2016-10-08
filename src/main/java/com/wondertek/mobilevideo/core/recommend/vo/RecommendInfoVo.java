package com.wondertek.mobilevideo.core.recommend.vo;

import java.io.Serializable;

public class RecommendInfoVo implements Serializable{
	private static final long serialVersionUID = -2245193354109763086L;
	
	private Long prdContId;		//节目ID
	private String contName;	//节目名称
	
	public Long getPrdContId() {
		return prdContId;
	}
	public void setPrdContId(Long prdContId) {
		this.prdContId = prdContId;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contName == null) ? 0 : contName.hashCode());
		result = prime * result + ((prdContId == null) ? 0 : prdContId.hashCode());
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
		RecommendInfoVo other = (RecommendInfoVo) obj;
		if (contName == null) {
			if (other.contName != null)
				return false;
		} else if (!contName.equals(other.contName))
			return false;
		if (prdContId == null) {
			if (other.prdContId != null)
				return false;
		} else if (!prdContId.equals(other.prdContId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RecommendInfoVo [prdContId=" + prdContId + ", contName=" + contName + "]";
	}
}
