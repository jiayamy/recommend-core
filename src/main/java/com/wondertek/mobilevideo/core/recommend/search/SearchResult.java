package com.wondertek.mobilevideo.core.recommend.search;

import java.io.Serializable;
/**
//      private final static String POMS = "searchId,contId,mediaDirector,mediaActor,mediaType,pyFirst";
//      private final static String POMS_RCMD = "searchId,contName,score,hits,publishTime,contDisplayType";
 * @author lvliuzhong
 *
 */
public class SearchResult implements Serializable {
	private static final long serialVersionUID = 570266959482023481L;
	
	private String contentId;
	private String contName;
	private Double score;
	private Double hits;
	private Long publishTime;
	private String contDisplayType;
	
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getHits() {
		return hits;
	}
	public void setHits(Double hits) {
		this.hits = hits;
	}
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	public String getContDisplayType() {
		return contDisplayType;
	}
	public void setContDisplayType(String contDisplayType) {
		this.contDisplayType = contDisplayType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contDisplayType == null) ? 0 : contDisplayType.hashCode());
		result = prime * result + ((contName == null) ? 0 : contName.hashCode());
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result + ((hits == null) ? 0 : hits.hashCode());
		result = prime * result + ((publishTime == null) ? 0 : publishTime.hashCode());
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
		SearchResult other = (SearchResult) obj;
		if (contDisplayType == null) {
			if (other.contDisplayType != null)
				return false;
		} else if (!contDisplayType.equals(other.contDisplayType))
			return false;
		if (contName == null) {
			if (other.contName != null)
				return false;
		} else if (!contName.equals(other.contName))
			return false;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (hits == null) {
			if (other.hits != null)
				return false;
		} else if (!hits.equals(other.hits))
			return false;
		if (publishTime == null) {
			if (other.publishTime != null)
				return false;
		} else if (!publishTime.equals(other.publishTime))
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
		return "SearchResult [contentId=" + contentId + ", contName=" + contName + ", score=" + score + ", hits=" + hits
				+ ", publishTime=" + publishTime + ", contDisplayType=" + contDisplayType + "]";
	}
}
