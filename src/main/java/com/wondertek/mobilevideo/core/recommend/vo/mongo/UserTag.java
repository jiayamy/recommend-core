package com.wondertek.mobilevideo.core.recommend.vo.mongo;

import java.io.Serializable;
import java.util.List;

import org.msgpack.annotation.Message;
/**
 * @author lvliuzhong
 */
@Message
public class UserTag implements Serializable{
	private static final long serialVersionUID = 3521383326178114024L;
	
	private String id;		//用户ID
	private String prdType;	//产品类型
	private Integer start;	//分页开始
	private Integer limit;	//每页条数
	private String order;	//排序（暂时不用传参数）
	private String ctVer;	//客户端版本号
	private String vomsLabel;	//voms的推荐标签
	private List<CatInfo> cats;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrdType() {
		return prdType;
	}
	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getCtVer() {
		return ctVer;
	}
	public void setCtVer(String ctVer) {
		this.ctVer = ctVer;
	}
	public String getVomsLabel() {
		return vomsLabel;
	}
	public void setVomsLabel(String vomsLabel) {
		this.vomsLabel = vomsLabel;
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
		result = prime * result + ((ctVer == null) ? 0 : ctVer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((limit == null) ? 0 : limit.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((prdType == null) ? 0 : prdType.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		if (ctVer == null) {
			if (other.ctVer != null)
				return false;
		} else if (!ctVer.equals(other.ctVer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (limit == null) {
			if (other.limit != null)
				return false;
		} else if (!limit.equals(other.limit))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (prdType == null) {
			if (other.prdType != null)
				return false;
		} else if (!prdType.equals(other.prdType))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserTag [id=" + id + ", prdType=" + prdType + ", start=" + start + ", limit=" + limit + ", order="
				+ order + ", ctVer=" + ctVer + ", cats=" + cats + "]";
	}
}
