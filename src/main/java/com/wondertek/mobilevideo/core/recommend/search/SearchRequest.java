package com.wondertek.mobilevideo.core.recommend.search;

/**
 * 搜索请求对象
 * 
 */
public class SearchRequest {
	public static final String CORE_NAME_DEFAULT = "program";
	public static final String TYPE_DEFAULT = "2";
	public static final String ORDER_DEFAULT = "1";
	private String ct;
	private String ctVer;
	private String ua;
	private String type = TYPE_DEFAULT;
	private String keyword;
	private String coreName = CORE_NAME_DEFAULT;
	private String fields;
	private String packId;
	private String contDisplayType;
	private String mediaShape;
	private String pageSize;
	private String pageStart;
	private String order = ORDER_DEFAULT;
	
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getCtVer() {
		return ctVer;
	}
	public void setCtVer(String ctVer) {
		this.ctVer = ctVer;
	}
	public String getUa() {
		return ua;
	}
	public void setUa(String ua) {
		this.ua = ua;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCoreName() {
		return coreName;
	}
	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public String getPackId() {
		return packId;
	}
	public void setPackId(String packId) {
		this.packId = packId;
	}
	public String getContDisplayType() {
		return contDisplayType;
	}
	public void setContDisplayType(String contDisplayType) {
		this.contDisplayType = contDisplayType;
	}
	public String getMediaShape() {
		return mediaShape;
	}
	public void setMediaShape(String mediaShape) {
		this.mediaShape = mediaShape;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageStart() {
		return pageStart;
	}
	public void setPageStart(String pageStart) {
		this.pageStart = pageStart;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contDisplayType == null) ? 0 : contDisplayType.hashCode());
		result = prime * result + ((coreName == null) ? 0 : coreName.hashCode());
		result = prime * result + ((ct == null) ? 0 : ct.hashCode());
		result = prime * result + ((ctVer == null) ? 0 : ctVer.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((mediaShape == null) ? 0 : mediaShape.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((packId == null) ? 0 : packId.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((pageStart == null) ? 0 : pageStart.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((ua == null) ? 0 : ua.hashCode());
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
		SearchRequest other = (SearchRequest) obj;
		if (contDisplayType == null) {
			if (other.contDisplayType != null)
				return false;
		} else if (!contDisplayType.equals(other.contDisplayType))
			return false;
		if (coreName == null) {
			if (other.coreName != null)
				return false;
		} else if (!coreName.equals(other.coreName))
			return false;
		if (ct == null) {
			if (other.ct != null)
				return false;
		} else if (!ct.equals(other.ct))
			return false;
		if (ctVer == null) {
			if (other.ctVer != null)
				return false;
		} else if (!ctVer.equals(other.ctVer))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (mediaShape == null) {
			if (other.mediaShape != null)
				return false;
		} else if (!mediaShape.equals(other.mediaShape))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (packId == null) {
			if (other.packId != null)
				return false;
		} else if (!packId.equals(other.packId))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (pageStart == null) {
			if (other.pageStart != null)
				return false;
		} else if (!pageStart.equals(other.pageStart))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (ua == null) {
			if (other.ua != null)
				return false;
		} else if (!ua.equals(other.ua))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SearchRequest [ct=" + ct + ", ctVer=" + ctVer + ", ua=" + ua + ", type=" + type + ", keyword=" + keyword
				+ ", coreName=" + coreName + ", fields=" + fields + ", packId=" + packId + ", contDisplayType="
				+ contDisplayType + ", mediaShape=" + mediaShape + ", pageSize=" + pageSize + ", pageStart=" + pageStart
				+ ", order=" + order + "]";
	}
}
