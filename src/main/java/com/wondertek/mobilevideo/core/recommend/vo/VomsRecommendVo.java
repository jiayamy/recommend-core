package com.wondertek.mobilevideo.core.recommend.vo;

import java.io.Serializable;
import java.util.Date;

import com.wondertek.mobilevideo.core.recommend.util.RecommendUtil;

/**
 * 展示推荐VO
 * 
 * @author madongwei
 *
 */
public class VomsRecommendVo implements Serializable{
	private static final long serialVersionUID = -7685693390446591745L;
	
	private Long objId; //推荐对象ID
	private String name; //名称
	private String objType;//推荐对象
	private String type; //类型
	private Long publishTime;	//发布时间
	
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

	public Long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}

	public VomsRecommendVo() {
	}

	public VomsRecommendVo(Long objId, String name, String objType, String type, Date updateTime) {
		this.objId = objId;
		this.name = name;
		this.objType = objType;
		this.type = type;
		this.publishTime = RecommendUtil.getYYYYMMDDHHMMFormat(updateTime);
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objId == null) ? 0 : objId.hashCode());
		result = prime * result + ((objType == null) ? 0 : objType.hashCode());
		result = prime * result + ((publishTime == null) ? 0 : publishTime.hashCode());
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
		VomsRecommendVo other = (VomsRecommendVo) obj;
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
		if (publishTime == null) {
			if (other.publishTime != null)
				return false;
		} else if (!publishTime.equals(other.publishTime))
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
		return "VomsRecommendVo [objId=" + objId + ", name=" + name + ", objType=" + objType + ", type=" + type
				+ ", publishTime=" + publishTime + "]";
	}
	
}
