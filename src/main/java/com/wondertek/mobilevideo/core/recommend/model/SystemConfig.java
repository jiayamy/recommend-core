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
 * 系统参数
 * @author lvliuzhong
 *
 */
@Entity
@Table(name = "R_SYSTEM_CONFIG", uniqueConstraints = { 
		@UniqueConstraint(columnNames = {"CONFIG_KEY"}) 
})
public class SystemConfig extends BaseObject {

	private static final long serialVersionUID = -3457185596618347969L;

	private Long id; 			// id
	private String configKey; 	// 系统参数主键
	private String configValue; // 系统参数值
	private String detail; 		// 系统参数说明

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_SYSTEM_CONFIG")
	@SequenceGenerator(name = "SEQ_R_SYSTEM_CONFIG", allocationSize = 1, sequenceName = "SEQ_R_SYSTEM_CONFIG")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CONFIG_KEY")
	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	@Column(name = "CONFIG_VALUE")
	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}


	@Column(name = "DETAIL_")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configKey == null) ? 0 : configKey.hashCode());
		result = prime * result + ((configValue == null) ? 0 : configValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SystemConfig other = (SystemConfig) obj;
		if (configKey == null) {
			if (other.configKey != null)
				return false;
		} else if (!configKey.equals(other.configKey))
			return false;
		if (configValue == null) {
			if (other.configValue != null)
				return false;
		} else if (!configValue.equals(other.configValue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemConfig [id=" + id + ", configKey=" + configKey + ", configValue=" + configValue + ", detail="
				+ detail + "]";
	}
}
