package com.wondertek.mobilevideo.core.recommend.search;

/**
 * 搜索请求对象
 * 
 */
public class SearchRequest {
	public static final String CORE_NAME_DEFAULT = "program";
	public static final String TYPE_DEFAULT = "2";
	public static final String ORDER_DEFAULT = "0";
	
	private String msisdn;
	private String ct;
	private String ctVer;
	private String ua;
	private String type = TYPE_DEFAULT;
	private String keyword;
	private String coreName = CORE_NAME_DEFAULT;
	private String fields;
	private String packId;
	private String limitDate;
	private String contDisplayType;
	private String mediaType;
	private String mediaShape;
	private String mediaYear;
	private String mediaMing;
	private String mediaChu;
	private String mediaArea;
	private String pageSize;
	private String pageStart;
	private String order = ORDER_DEFAULT;
	private String mediaGkzp;
	private String mediaPlat;
	private String mediaProj;
    private String mediaMovieForm;
    
    /**
	 * 是否杜比
	 */
	private String mediaIsDubi;
	
	/**
	 * 导演
	 */
	private String mediaDirector;
	
	/**
	 * 评分
	 */
	private String mediaScore;
	
	/**
	 * 所属片名
	 */
	private String mediaVideoName;
	
	/**
	 * 上映时间
	 */
	private String mediaTime;
	
	/**
	 * 针对电视剧节目是否完结
	 */
	private String isUpdating;
	
	/**
	 * 剧集类型
	 * 过滤一级分类为电视剧、动漫等时，增加此属性。
	 * 枚举值（单选）
	 * 6：剧集壳；8：点播；9：专辑
	 */
	private String contFormType;
	
	/**
	 * G客活动
	 * 可用“;”组合
	 * 分层分级枚举值：
	 * 剧情/创意/动画/纪录/音乐
	 */
	private String mediaGkhd;
	
	/**
	 * 报道地区, 可用“,”组合分层分级枚举值：北京上海
	 */
	private String mediaReportArea;
    
	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

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

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public String getContDisplayType() {
		return contDisplayType;
	}

	public void setContDisplayType(String contDisplayType) {
		this.contDisplayType = contDisplayType;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaShape() {
		return mediaShape;
	}

	public void setMediaShape(String mediaShape) {
		this.mediaShape = mediaShape;
	}

	public String getMediaYear() {
		return mediaYear;
	}

	public void setMediaYear(String mediaYear) {
		this.mediaYear = mediaYear;
	}

	public String getMediaMing() {
		return mediaMing;
	}

	public void setMediaMing(String mediaMing) {
		this.mediaMing = mediaMing;
	}

	public String getMediaChu() {
		return mediaChu;
	}

	public void setMediaChu(String mediaChu) {
		this.mediaChu = mediaChu;
	}

	public String getMediaArea() {
		return mediaArea;
	}

	public void setMediaArea(String mediaArea) {
		this.mediaArea = mediaArea;
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

	public String getMediaGkzp() {
		return mediaGkzp;
	}

	public void setMediaGkzp(String mediaGkzp) {
		this.mediaGkzp = mediaGkzp;
	}

	public String getMediaPlat() {
		return mediaPlat;
	}

	public void setMediaPlat(String mediaPlat) {
		this.mediaPlat = mediaPlat;
	}

	public String getMediaProj() {
		return mediaProj;
	}

	public void setMediaProj(String mediaProj) {
		this.mediaProj = mediaProj;
	}

	public String getMediaMovieForm() {
		return mediaMovieForm;
	}

	public void setMediaMovieForm(String mediaMovieForm) {
		this.mediaMovieForm = mediaMovieForm;
	}

	public String getMediaIsDubi() {
		return mediaIsDubi;
	}

	public void setMediaIsDubi(String mediaIsDubi) {
		this.mediaIsDubi = mediaIsDubi;
	}

	public String getMediaDirector() {
		return mediaDirector;
	}

	public void setMediaDirector(String mediaDirector) {
		this.mediaDirector = mediaDirector;
	}

	public String getMediaScore() {
		return mediaScore;
	}

	public void setMediaScore(String mediaScore) {
		this.mediaScore = mediaScore;
	}

	public String getMediaVideoName() {
		return mediaVideoName;
	}

	public void setMediaVideoName(String mediaVideoName) {
		this.mediaVideoName = mediaVideoName;
	}

	public String getMediaTime() {
		return mediaTime;
	}

	public void setMediaTime(String mediaTime) {
		this.mediaTime = mediaTime;
	}

	public String getIsUpdating() {
		return isUpdating;
	}

	public void setIsUpdating(String isUpdating) {
		this.isUpdating = isUpdating;
	}

	public String getContFormType() {
		return contFormType;
	}

	public void setContFormType(String contFormType) {
		this.contFormType = contFormType;
	}

	public String getMediaGkhd() {
		return mediaGkhd;
	}

	public void setMediaGkhd(String mediaGkhd) {
		this.mediaGkhd = mediaGkhd;
	}

	public String getMediaReportArea() {
		return mediaReportArea;
	}

	public void setMediaReportArea(String mediaReportArea) {
		this.mediaReportArea = mediaReportArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contDisplayType == null) ? 0 : contDisplayType.hashCode());
		result = prime * result + ((contFormType == null) ? 0 : contFormType.hashCode());
		result = prime * result + ((coreName == null) ? 0 : coreName.hashCode());
		result = prime * result + ((ct == null) ? 0 : ct.hashCode());
		result = prime * result + ((ctVer == null) ? 0 : ctVer.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((isUpdating == null) ? 0 : isUpdating.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((limitDate == null) ? 0 : limitDate.hashCode());
		result = prime * result + ((mediaArea == null) ? 0 : mediaArea.hashCode());
		result = prime * result + ((mediaChu == null) ? 0 : mediaChu.hashCode());
		result = prime * result + ((mediaDirector == null) ? 0 : mediaDirector.hashCode());
		result = prime * result + ((mediaGkhd == null) ? 0 : mediaGkhd.hashCode());
		result = prime * result + ((mediaGkzp == null) ? 0 : mediaGkzp.hashCode());
		result = prime * result + ((mediaIsDubi == null) ? 0 : mediaIsDubi.hashCode());
		result = prime * result + ((mediaMing == null) ? 0 : mediaMing.hashCode());
		result = prime * result + ((mediaMovieForm == null) ? 0 : mediaMovieForm.hashCode());
		result = prime * result + ((mediaPlat == null) ? 0 : mediaPlat.hashCode());
		result = prime * result + ((mediaProj == null) ? 0 : mediaProj.hashCode());
		result = prime * result + ((mediaReportArea == null) ? 0 : mediaReportArea.hashCode());
		result = prime * result + ((mediaScore == null) ? 0 : mediaScore.hashCode());
		result = prime * result + ((mediaShape == null) ? 0 : mediaShape.hashCode());
		result = prime * result + ((mediaTime == null) ? 0 : mediaTime.hashCode());
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((mediaVideoName == null) ? 0 : mediaVideoName.hashCode());
		result = prime * result + ((mediaYear == null) ? 0 : mediaYear.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
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
		if (contFormType == null) {
			if (other.contFormType != null)
				return false;
		} else if (!contFormType.equals(other.contFormType))
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
		if (isUpdating == null) {
			if (other.isUpdating != null)
				return false;
		} else if (!isUpdating.equals(other.isUpdating))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (limitDate == null) {
			if (other.limitDate != null)
				return false;
		} else if (!limitDate.equals(other.limitDate))
			return false;
		if (mediaArea == null) {
			if (other.mediaArea != null)
				return false;
		} else if (!mediaArea.equals(other.mediaArea))
			return false;
		if (mediaChu == null) {
			if (other.mediaChu != null)
				return false;
		} else if (!mediaChu.equals(other.mediaChu))
			return false;
		if (mediaDirector == null) {
			if (other.mediaDirector != null)
				return false;
		} else if (!mediaDirector.equals(other.mediaDirector))
			return false;
		if (mediaGkhd == null) {
			if (other.mediaGkhd != null)
				return false;
		} else if (!mediaGkhd.equals(other.mediaGkhd))
			return false;
		if (mediaGkzp == null) {
			if (other.mediaGkzp != null)
				return false;
		} else if (!mediaGkzp.equals(other.mediaGkzp))
			return false;
		if (mediaIsDubi == null) {
			if (other.mediaIsDubi != null)
				return false;
		} else if (!mediaIsDubi.equals(other.mediaIsDubi))
			return false;
		if (mediaMing == null) {
			if (other.mediaMing != null)
				return false;
		} else if (!mediaMing.equals(other.mediaMing))
			return false;
		if (mediaMovieForm == null) {
			if (other.mediaMovieForm != null)
				return false;
		} else if (!mediaMovieForm.equals(other.mediaMovieForm))
			return false;
		if (mediaPlat == null) {
			if (other.mediaPlat != null)
				return false;
		} else if (!mediaPlat.equals(other.mediaPlat))
			return false;
		if (mediaProj == null) {
			if (other.mediaProj != null)
				return false;
		} else if (!mediaProj.equals(other.mediaProj))
			return false;
		if (mediaReportArea == null) {
			if (other.mediaReportArea != null)
				return false;
		} else if (!mediaReportArea.equals(other.mediaReportArea))
			return false;
		if (mediaScore == null) {
			if (other.mediaScore != null)
				return false;
		} else if (!mediaScore.equals(other.mediaScore))
			return false;
		if (mediaShape == null) {
			if (other.mediaShape != null)
				return false;
		} else if (!mediaShape.equals(other.mediaShape))
			return false;
		if (mediaTime == null) {
			if (other.mediaTime != null)
				return false;
		} else if (!mediaTime.equals(other.mediaTime))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		if (mediaVideoName == null) {
			if (other.mediaVideoName != null)
				return false;
		} else if (!mediaVideoName.equals(other.mediaVideoName))
			return false;
		if (mediaYear == null) {
			if (other.mediaYear != null)
				return false;
		} else if (!mediaYear.equals(other.mediaYear))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
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
		return "PomsSearchRequest [msisdn=" + msisdn + ", ct=" + ct + ", ctVer=" + ctVer + ", ua=" + ua + ", type="
				+ type + ", keyword=" + keyword + ", coreName=" + coreName + ", fields=" + fields + ", packId="
				+ packId + ", limitDate=" + limitDate + ", contDisplayType=" + contDisplayType + ", mediaType="
				+ mediaType + ", mediaShape=" + mediaShape + ", mediaYear=" + mediaYear + ", mediaMing=" + mediaMing
				+ ", mediaChu=" + mediaChu + ", mediaArea=" + mediaArea + ", pageSize=" + pageSize + ", pageStart="
				+ pageStart + ", order=" + order + ", mediaGkzp=" + mediaGkzp + ", mediaPlat=" + mediaPlat
				+ ", mediaProj=" + mediaProj + ", mediaMovieForm=" + mediaMovieForm + ", mediaIsDubi=" + mediaIsDubi
				+ ", mediaDirector=" + mediaDirector + ", mediaScore=" + mediaScore + ", mediaVideoName="
				+ mediaVideoName + ", mediaTime=" + mediaTime + ", isUpdating=" + isUpdating + ", contFormType="
				+ contFormType + ", mediaGkhd=" + mediaGkhd + ", mediaReportArea=" + mediaReportArea + "]";
	}
}
