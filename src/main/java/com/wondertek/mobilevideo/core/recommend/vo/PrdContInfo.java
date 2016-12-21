package com.wondertek.mobilevideo.core.recommend.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;


/**
 * @author Administrator
 *
 */
public class PrdContInfo implements Serializable {
	private static final long serialVersionUID = 2557828465474382687L;

	private Long prdContId;
	private String contentId;
	private Integer bcStatus;
	private Integer pubStatus;
	private Integer publishNoVomsStatus;
	private String formType;
	private Date createTime;
	private Date updateTime;
	private String prdInfoName;
	private String cpId; 
	private String name;
	private String displayName;
	public PrdContInfo() {
	}
	public PrdContInfo(Long prdContId, String name) {
		this.prdContId = prdContId;
		this.name = name;
	}
	public Long getPrdContId() {
		return prdContId;
	}
	public void setPrdContId(Long prdContId) {
		this.prdContId = prdContId;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public Integer getBcStatus() {
		return bcStatus;
	}
	public void setBcStatus(Integer bcStatus) {
		this.bcStatus = bcStatus;
	}
	public Integer getPubStatus() {
		return pubStatus;
	}
	public void setPubStatus(Integer pubStatus) {
		this.pubStatus = pubStatus;
	}
	public Integer getPublishNoVomsStatus() {
		return publishNoVomsStatus;
	}
	public void setPublishNoVomsStatus(Integer publishNoVomsStatus) {
		this.publishNoVomsStatus = publishNoVomsStatus;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getPrdInfoName() {
		return prdInfoName;
	}
	public void setPrdInfoName(String prdInfoName) {
		this.prdInfoName = prdInfoName;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public PrdContInfo(Long prdContId, String contentId, Integer bcStatus, Integer pubStatus,
			Integer publishNoVomsStatus, String formType, Date createTime, Date updateTime, String prdInfoName,
			String cpId, String name, String displayName) {
		this.prdContId = prdContId;
		this.contentId = contentId;
		this.bcStatus = bcStatus;
		this.pubStatus = pubStatus;
		this.publishNoVomsStatus = publishNoVomsStatus;
		this.formType = formType;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.prdInfoName = prdInfoName;
		this.cpId = cpId;
		this.name = name;
		this.displayName = displayName;
	}
	@Override
	public String toString() {
		return "PrdContInfo [prdContId=" + prdContId + ", contentId=" + contentId + ", bcStatus=" + bcStatus
				+ ", pubStatus=" + pubStatus + ", publishNoVomsStatus=" + publishNoVomsStatus + ", formType=" + formType
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", prdInfoName=" + prdInfoName
				+ ", cpId=" + cpId + ", name=" + name + ", displayName=" + displayName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bcStatus == null) ? 0 : bcStatus.hashCode());
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result + ((cpId == null) ? 0 : cpId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((formType == null) ? 0 : formType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prdContId == null) ? 0 : prdContId.hashCode());
		result = prime * result + ((prdInfoName == null) ? 0 : prdInfoName.hashCode());
		result = prime * result + ((pubStatus == null) ? 0 : pubStatus.hashCode());
		result = prime * result + ((publishNoVomsStatus == null) ? 0 : publishNoVomsStatus.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
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
		PrdContInfo other = (PrdContInfo) obj;
		if (bcStatus == null) {
			if (other.bcStatus != null)
				return false;
		} else if (!bcStatus.equals(other.bcStatus))
			return false;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (cpId == null) {
			if (other.cpId != null)
				return false;
		} else if (!cpId.equals(other.cpId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (formType == null) {
			if (other.formType != null)
				return false;
		} else if (!formType.equals(other.formType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prdContId == null) {
			if (other.prdContId != null)
				return false;
		} else if (!prdContId.equals(other.prdContId))
			return false;
		if (prdInfoName == null) {
			if (other.prdInfoName != null)
				return false;
		} else if (!prdInfoName.equals(other.prdInfoName))
			return false;
		if (pubStatus == null) {
			if (other.pubStatus != null)
				return false;
		} else if (!pubStatus.equals(other.pubStatus))
			return false;
		if (publishNoVomsStatus == null) {
			if (other.publishNoVomsStatus != null)
				return false;
		} else if (!publishNoVomsStatus.equals(other.publishNoVomsStatus))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}
	
}
