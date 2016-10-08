package com.wondertek.mobilevideo.core.recommend.mongo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.wondertek.mobilevideo.core.recommend.vo.mongo.CatInfo;
/**
 * @author lvliuzhong
 */
@Document(collection="recomm_user_tag")
public class UserTag implements Serializable{
	private static final long serialVersionUID = 2043514468248281007L;
	
	@Id
	@Field("_id")
	private String id;
	@Field
	private List<CatInfo> cats;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<CatInfo> getCats() {
		return cats;
	}
	public void setCats(List<CatInfo> cats) {
		this.cats = cats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cats == null) ? 0 : cats.hashCode());
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
		UserTag other = (UserTag) obj;
		if (cats == null) {
			if (other.cats != null)
				return false;
		} else if (!cats.equals(other.cats))
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
		return "UserTag [id=" + id + ", cats=" + cats + "]";
	}
}
