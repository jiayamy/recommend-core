package com.wondertek.mobilevideo.core.recommend.util;

import com.alibaba.fastjson.JSON;
import com.wondertek.mobilevideo.core.recommend.vo.mongo.UserTag;

public class TestJson {
	public static void main(String[] args){
		String text = "";
		//门户访问
		text = "{\"id\":\"100033899\",\"prdType\":\"MIGUSHIPIN\",\"cats\":[{\"catName\":\"电视剧\",\"items\":[{\"labelName\":\"播出年代\",\"labelValue\":\"2015\"},{\"labelName\":\"首播时间\",\"labelValue\":\"2015-05-03\"},{\"labelName\":\"内容类型\",\"labelValue\":\"都市\"},{\"labelName\":\"内容类型\",\"labelValue\":\"言情\"}]},{\"catName\":\"电影\",\"items\":[{\"labelName\":\"内容类型\",\"labelValue\":\"冒险\"}]},{\"catName\":\"原创\",\"items\":[{\"labelName\":\"国家及地区\",\"labelValue\":\"内地\"},{\"labelName\":\"播出年代\",\"labelValue\":\"2016\"},{\"labelName\":\"内容形态\",\"labelValue\":\"全片\"}]}],\"recommendation\":{\"items\":[{\"label\":\"影视资讯\"},{\"label\":\"社会\"}]},\"keywords\":{\"items\":[{\"keyword\":\" 保健秘籍\"},{\"keyword\":\" 时尚女性\"}]}}";
		//mongo
		text = "{\"id\":\"100033899\",\"cats\":[{\"catName\":\"电视剧\",\"score\":342,\"items\":[{\"labelName\":\"播出年代\",\"labelValue\":\"2015\",\"score\":342},{\"labelName\":\"首播时间\",\"labelValue\":\"2015-05-03\",\"score\":342},{\"labelName\":\"内容类型\",\"labelValue\":\"都市\",\"score\":342},{\"labelName\":\"内容类型\",\"labelValue\":\"言情\",\"score\":342}]},{\"catName\":\"电影\",\"score\":342,\"items\":[{\"labelName\":\"内容类型\",\"labelValue\":\"冒险\",\"score\":342}]},{\"catName\":\"原创\",\"score\":342,\"items\":[{\"labelName\":\"国家及地区\",\"labelValue\":\"内地\",\"score\":342},{\"labelName\":\"播出年代\",\"labelValue\":\"2016\",\"score\":342},{\"labelName\":\"内容形态\",\"labelValue\":\"全片\",\"score\":342}]}],\"recommendation\":{\"items\":[{\"label\":\"影视资讯\",\"score\":342},{\"label\":\"社会\",\"score\":342}]},\"keywords\":{\"items\":[{\"keyword\":\" 保健秘籍\",\"score\":342},{\"keyword\":\" 时尚女性\",\"score\":342}]}}";
		//
		text = "{}";
		UserTag UserTag = JSON.parseObject(text, UserTag.class);
		System.out.println(UserTag);
	}
}