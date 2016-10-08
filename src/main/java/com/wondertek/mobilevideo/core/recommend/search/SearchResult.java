package com.wondertek.mobilevideo.core.recommend.search;

import java.io.Serializable;

public class SearchResult implements Serializable {
	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 570266959482023481L;
	private String resultType;
	private String contentId;
	private String contentName;
	private String url;
	private String category;
	private String type;
	private String nodeId;
	private String nodeName;
	private String packageId;
	private long startTime;
	private long endTime;
	private String formType;
	private String displayType;
	private long hits;
	private String publishTime;
	private long updateTime;
	private String watch_point;
	private String searchId;
	private String mediaDirector;
	private String mediaActor;
	private String mediaType;
	private long score;

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public String getWatch_point() {
		return watch_point;
	}

	public void setWatch_point(String watch_point) {
		this.watch_point = watch_point;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getMediaDirector() {
		return mediaDirector;
	}

	public void setMediaDirector(String mediaDirector) {
		this.mediaDirector = mediaDirector;
	}

	public String getMediaActor() {
		return mediaActor;
	}

	public void setMediaActor(String mediaActor) {
		this.mediaActor = mediaActor;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result
				+ ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result
				+ ((displayType == null) ? 0 : displayType.hashCode());
		result = prime * result + (int) (endTime ^ (endTime >>> 32));
		result = prime * result
				+ ((formType == null) ? 0 : formType.hashCode());
		result = prime * result + (int) (hits ^ (hits >>> 32));
		result = prime * result
				+ ((mediaActor == null) ? 0 : mediaActor.hashCode());
		result = prime * result
				+ ((mediaDirector == null) ? 0 : mediaDirector.hashCode());
		result = prime * result
				+ ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result
				+ ((nodeName == null) ? 0 : nodeName.hashCode());
		result = prime * result
				+ ((packageId == null) ? 0 : packageId.hashCode());
		result = prime * result
				+ ((publishTime == null) ? 0 : publishTime.hashCode());
		result = prime * result
				+ ((resultType == null) ? 0 : resultType.hashCode());
		result = prime * result + (int) (score ^ (score >>> 32));
		result = prime * result
				+ ((searchId == null) ? 0 : searchId.hashCode());
		result = prime * result + (int) (startTime ^ (startTime >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (int) (updateTime ^ (updateTime >>> 32));
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result
				+ ((watch_point == null) ? 0 : watch_point.hashCode());
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName))
			return false;
		if (displayType == null) {
			if (other.displayType != null)
				return false;
		} else if (!displayType.equals(other.displayType))
			return false;
		if (endTime != other.endTime)
			return false;
		if (formType == null) {
			if (other.formType != null)
				return false;
		} else if (!formType.equals(other.formType))
			return false;
		if (hits != other.hits)
			return false;
		if (mediaActor == null) {
			if (other.mediaActor != null)
				return false;
		} else if (!mediaActor.equals(other.mediaActor))
			return false;
		if (mediaDirector == null) {
			if (other.mediaDirector != null)
				return false;
		} else if (!mediaDirector.equals(other.mediaDirector))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		if (publishTime == null) {
			if (other.publishTime != null)
				return false;
		} else if (!publishTime.equals(other.publishTime))
			return false;
		if (resultType == null) {
			if (other.resultType != null)
				return false;
		} else if (!resultType.equals(other.resultType))
			return false;
		if (score != other.score)
			return false;
		if (searchId == null) {
			if (other.searchId != null)
				return false;
		} else if (!searchId.equals(other.searchId))
			return false;
		if (startTime != other.startTime)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updateTime != other.updateTime)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (watch_point == null) {
			if (other.watch_point != null)
				return false;
		} else if (!watch_point.equals(other.watch_point))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SearchResult [resultType=" + resultType + ", contentId="
				+ contentId + ", contentName=" + contentName + ", url=" + url
				+ ", category=" + category + ", type=" + type + ", nodeId="
				+ nodeId + ", nodeName=" + nodeName + ", packageId="
				+ packageId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", formType=" + formType + ", displayType="
				+ displayType + ", hits=" + hits + ", publishTime="
				+ publishTime + ", updateTime=" + updateTime + ", watch_point="
				+ watch_point + ", searchId=" + searchId + ", mediaDirector="
				+ mediaDirector + ", mediaActor=" + mediaActor + ", mediaType="
				+ mediaType + ", score=" + score + "]";
	}

}
