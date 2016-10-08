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
 * 推荐信息
 * @author lvliuzhong
 *
 */
@Entity
@Table(name = "R_INFO")
public class RecommendInfo extends BaseObject {
	private static final long serialVersionUID = -2673637104786245050L;
	
	private Long id;			// id
	private String labelInfo;	//标签名（多个以英文逗号分隔），保存时头尾都带“,”
	private String prdType;		//产品
	private String catId;		//一级分类
	private Long prdContId;		//节目ID
	private String contName;	//节目名称
	private int status;			//状态，0禁用，1启用
	private Date createTime;
	private String creator;
	private Date updateTime;
	private String updator;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_INFO")
	@SequenceGenerator(name = "SEQ_R_INFO", allocationSize = 1, sequenceName = "SEQ_R_INFO")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="LABEL_INFO")
	public String getLabelInfo() {
		return labelInfo;
	}

	public void setLabelInfo(String labelInfo) {
		this.labelInfo = labelInfo;
	}
	@Column(name="PRD_TYPE")
	public String getPrdType() {
		return prdType;
	}

	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}
	
	@Column(name="CAT_ID")
	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	@Column(name="PRD_CONTID")
	public Long getPrdContId() {
		return prdContId;
	}

	public void setPrdContId(Long prdContId) {
		this.prdContId = prdContId;
	}
	@Column(name="CONT_NAME")
	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	@Column(name="STATUS_")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="CREATE_TIME")
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="CREATOR_")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name="UPDATE_TIME")
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name="UPDATOR_")
	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contName == null) ? 0 : contName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((labelInfo == null) ? 0 : labelInfo.hashCode());
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
		RecommendInfo other = (RecommendInfo) obj;
		if (contName == null) {
			if (other.contName != null)
				return false;
		} else if (!contName.equals(other.contName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (labelInfo == null) {
			if (other.labelInfo != null)
				return false;
		} else if (!labelInfo.equals(other.labelInfo))
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
		return "RecommendInfo [id=" + id + ", labelInfo=" + labelInfo + ", prdContId=" + prdContId + ", contName="
				+ contName + "]";
	}
}
