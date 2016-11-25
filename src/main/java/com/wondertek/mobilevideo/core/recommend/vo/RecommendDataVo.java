package com.wondertek.mobilevideo.core.recommend.vo;

import java.io.Serializable;

/**
 * 展示推荐VO
 * 
 * @author madongwei
 *
 */
public class RecommendDataVo implements Serializable{
	private static final long serialVersionUID = -7685693390446591745L;
	
	private Long objId;
	private String name;
	private String objType;


	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public RecommendDataVo() {
	}

	public RecommendDataVo(Long objId, String name, String objType) {
		this.objId = objId;
		this.name = name;
		this.objType = objType;
	}

	@Override
	public String toString() {
		return "RecommendDataVo [objId=" + objId + ", name=" + name + ", objType=" + objType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objId == null) ? 0 : objId.hashCode());
		result = prime * result + ((objType == null) ? 0 : objType.hashCode());
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
		RecommendDataVo other = (RecommendDataVo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objId == null) {
			if (other.objId != null)
				return false;
		} else if (!objId.equals(other.objId))
			return false;
		if (objType == null) {
			if (other.objType != null)
				return false;
		} else if (!objType.equals(other.objType))
			return false;
		return true;
	}

	
	
}
