package com.wondertek.mobilevideo.core.recommend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

import com.wondertek.mobilevideo.core.base.BaseObject;
@Entity
@Table(name = "R_VOMS_RECOMMEND")
public class VomsRecommend extends BaseObject{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long objId;
	private String name;
	private int type; //0代表项目，1代表内容
	private Boolean isRecommend;    //true推荐   false撤回
	private String labelInfo;	//标签名（多个以英文逗号分隔），保存时头尾都带“,”
	private String prdType;		//产品
	private String updator;
	private String creator;
	private Date createTime;
	private Date updateTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_VOMS_RECOMMEND") 	
	@SequenceGenerator(name = "SEQ_R_VOMS_RECOMMEND", allocationSize = 1, sequenceName = "SEQ_R_VOMS_RECOMMEND")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "TYPE_")
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	
	@Column(name = "OBJ_ID")
	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "IS_RECOMMEND")
	public Boolean getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}
	@Column(name = "LABEL_INFO")
	public String getLabelInfo() {
		return labelInfo;
	}

	public void setLabelInfo(String labelInfo) {
		this.labelInfo = labelInfo;
	}
	@Column(name = "PRD_TYPE")
	public String getPrdType() {
		return prdType;
	}

	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}
	
	@Column(name = "UPDATOR_")
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}

	@Column(name = "CREATOR_")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	@Column(name = "CREATE_TIME")
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "UPDATE_TIME")
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isRecommend == null) ? 0 : isRecommend.hashCode());
		result = prime * result + ((labelInfo == null) ? 0 : labelInfo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objId == null) ? 0 : objId.hashCode());
		result = prime * result + ((prdType == null) ? 0 : prdType.hashCode());
		result = prime * result + type;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updator == null) ? 0 : updator.hashCode());
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
		VomsRecommend other = (VomsRecommend) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isRecommend == null) {
			if (other.isRecommend != null)
				return false;
		} else if (!isRecommend.equals(other.isRecommend))
			return false;
		if (labelInfo == null) {
			if (other.labelInfo != null)
				return false;
		} else if (!labelInfo.equals(other.labelInfo))
			return false;
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
		if (prdType == null) {
			if (other.prdType != null)
				return false;
		} else if (!prdType.equals(other.prdType))
			return false;
		if (type != other.type)
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updator == null) {
			if (other.updator != null)
				return false;
		} else if (!updator.equals(other.updator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VomsRecommend [id=" + id + ", objId=" + objId + ", name=" + name + ", type=" + type + ", isRecommend="
				+ isRecommend + ", labelInfo=" + labelInfo + ", prdType=" + prdType + ", updator=" + updator
				+ ", creator=" + creator + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	
	
	
}
