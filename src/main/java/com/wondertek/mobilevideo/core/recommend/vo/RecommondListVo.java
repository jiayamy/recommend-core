package com.wondertek.mobilevideo.core.recommend.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.wondertek.mobilevideo.core.recommend.model.EnumsInfo;
import com.wondertek.mobilevideo.core.recommend.model.RecommendParam;

public class RecommondListVo implements Serializable{


	private static final long serialVersionUID = -1331718835146474089L;
	
	private List<RecommendParam> data = new ArrayList<RecommendParam>();

	public List<RecommendParam> getData() {
		return data;
	}

	public void setData(List<RecommendParam> data) {
		this.data = data;
	}
	
	
	
	

}
