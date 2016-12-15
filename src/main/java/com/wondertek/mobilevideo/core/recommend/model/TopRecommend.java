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
/**
 * 
 * 置顶推荐
 * */
@Entity
@Table(name = "R_TOP_RECOMMEND")
public class TopRecommend extends BaseObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long topId;             //ID
	private String prdType;    //所属产品
	private String topName;  //节目名称
	private int status;			//状态，0禁用，1启用
	private String updator;
	private String creator;
	private Date createTime;
	private Date updateTime;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_TOP_RECOMMEND") 	
	@SequenceGenerator(name = "SEQ_R_TOP_RECOMMEND", allocationSize = 1, sequenceName = "SEQ_R_TOP_RECOMMEND")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "Top_ID")
	public Long getTopId() {
		return topId;
	}
	public void setTopId(Long topId) {
		this.topId = topId;
	}
	
	@Column(name = "PRD_TYPE")
	public String getPrdType() {
		return prdType;
	}
	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}
	
	@Column(name = "TOP_NAME")
	public String getTopName() {
		return topName;
	}
	public void setTopName(String topName) {
		this.topName = topName;
	}
	
	@Column(name="STATUS_")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		result = prime * result + ((prdType == null) ? 0 : prdType.hashCode());
		result = prime * result + status;
		result = prime * result + ((topId == null) ? 0 : topId.hashCode());
		result = prime * result + ((topName == null) ? 0 : topName.hashCode());
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
		TopRecommend other = (TopRecommend) obj;
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
		if (prdType == null) {
			if (other.prdType != null)
				return false;
		} else if (!prdType.equals(other.prdType))
			return false;
		if (status != other.status)
			return false;
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
		return "TopRecommend [id=" + id + ", topId=" + topId + ", prdType=" + prdType + ", topName=" + topName + ", status="
				+ status + ", updator=" + updator + ", creator=" + creator + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
}
