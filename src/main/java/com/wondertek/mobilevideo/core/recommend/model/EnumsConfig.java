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
 * 标签参数
 * @author Administrator
 *
 */
@Entity
@Table(name = "R_ENUMS_CONFIG")
public class EnumsConfig extends BaseObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5914045897260863589L;

	private Long id;
	
	private String key;
	
	private String value;
	
	private String type;
	
	private String weight;
	
	private String parent;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_R_ENUMS_INFO")
	@SequenceGenerator(name = "SEQ_R_ENUMS_INFO", allocationSize = 1, sequenceName = "SEQ_R_ENUMS_INFO")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "KEY_")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Column(name="VALUE_")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="TYPE_")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="WEIGHT")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@Column(name="PARENT")
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		EnumsConfig other = (EnumsConfig) obj;
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
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnumsConfig [id=" + id + ", key=" + key + ", value=" + value + ", type=" + type + ", weight=" + weight
				+ ", parent=" + parent + "]";
	}
	
	
}
