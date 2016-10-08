package com.wondertek.mobilevideo.core.recommend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.wondertek.mobilevideo.core.base.BaseObject;

/**
 * 产品对应的产品包ID
 * @author lvliuzhong
 *
 */
@Entity
@Table(name = "R_PRDTYPE_RELATION", uniqueConstraints = { 
		@UniqueConstraint(columnNames = {"PRD_TYPE"})
})
public class PrdTypeRelation extends BaseObject {
	private static final long serialVersionUID = 1597351489971808565L;
	
	private Long id;			// id
	private String prdType;		// 产品类型
	private String name;		// 产品名称
	private String prdInfoIds; 	// 产品包ID集合，英文逗号分隔
	private String searchCt;	//搜索接入类型
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_PRDTYPE_RELATION")
	@SequenceGenerator(name = "SEQ_R_PRDTYPE_RELATION", allocationSize = 1, sequenceName = "SEQ_R_PRDTYPE_RELATION")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="PRD_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="PRD_TYPE")
	public String getPrdType() {
		return prdType;
	}

	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}

	@Column(name="PRD_INFO_IDS")
	public String getPrdInfoIds() {
		return prdInfoIds;
	}

	public void setPrdInfoIds(String prdInfoIds) {
		this.prdInfoIds = prdInfoIds;
	}

	@Column(name="SEARCH_CT")
	public String getSearchCt() {
		return searchCt;
	}

	public void setSearchCt(String searchCt) {
		this.searchCt = searchCt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prdInfoIds == null) ? 0 : prdInfoIds.hashCode());
		result = prime * result + ((prdType == null) ? 0 : prdType.hashCode());
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
		PrdTypeRelation other = (PrdTypeRelation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prdInfoIds == null) {
			if (other.prdInfoIds != null)
				return false;
		} else if (!prdInfoIds.equals(other.prdInfoIds))
			return false;
		if (prdType == null) {
			if (other.prdType != null)
				return false;
		} else if (!prdType.equals(other.prdType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrdTypeRelation [id=" + id + ", prdType=" + prdType + ", prdInfoIds=" + prdInfoIds + "]";
	}
}
