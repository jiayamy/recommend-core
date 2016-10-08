package com.wondertek.mobilevideo.core.recommend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.wondertek.mobilevideo.core.base.BaseObject;

/**
 * 枚举值参数
 * @author lvliuzhong
 */
@Entity
@Table(name = "R_ENUMS_INFO")
public class EnumsInfo extends BaseObject {
	private static final long serialVersionUID = -2240827122769339505L;
	
	private Long id; 		// id
	private String key; 	// 系统参数主键
	private String val; 	// 系统参数值
	private int type; 		// 系统参数说明

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_ENUMS_INFO")
	@SequenceGenerator(name = "SEQ_R_ENUMS_INFO", allocationSize = 1, sequenceName = "SEQ_R_ENUMS_INFO")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="KEY_")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	@Column(name="VAL_")
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	@Column(name="TYPE_")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + type;
		result = prime * result + ((val == null) ? 0 : val.hashCode());
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
		EnumsInfo other = (EnumsInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (type != other.type)
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnumsInfo [id=" + id + ", key=" + key + ", val=" + val + ", type=" + type + "]";
	}
	
}
