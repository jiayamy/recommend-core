package com.wondertek.mobilevideo.core.recommend.vo.mongo;

import java.io.Serializable;
import java.util.List;

import org.msgpack.annotation.Message;

@Message
public class CatInfo implements Serializable{
	private static final long serialVersionUID = -8183202807648852662L;
	
	public String catName;	//一级分类
	public String catId;	//一级分类标示，搜索使用
	public Double score;
	public List<CatItem> items;
	public List<RecomdItem> recommendation;
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public List<CatItem> getItems() {
		return items;
	}
	public void setItems(List<CatItem> items) {
		this.items = items;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public List<RecomdItem> getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(List<RecomdItem> recommendation) {
		this.recommendation = recommendation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((recommendation == null) ? 0 : recommendation.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		CatInfo other = (CatInfo) obj;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (recommendation == null) {
			if (other.recommendation != null)
				return false;
		} else if (!recommendation.equals(other.recommendation))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CatInfo [catName=" + catName + ", catId=" + catId + ", score=" + score + ", items=" + items
				+ ", recommendation=" + recommendation + "]";
	}
}
