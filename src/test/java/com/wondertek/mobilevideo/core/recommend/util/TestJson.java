package com.wondertek.mobilevideo.core.recommend.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
		UserTag userTag = JSON.parseObject(text, UserTag.class);
		System.out.println(userTag);
		
		text = "{\"returnCode\":\"000000\",\"returnMsg\":\"请求成功\",\"root\":{\"cats\":[{\"catName\":\"新闻\",\"items\":[{\"labelName\":\"报道形式\",\"labelValue\":\"短讯\",\"score\":87.78},{\"labelName\":\"语言\",\"labelValue\":\"国语\",\"score\":52.22},{\"labelName\":\"内容类型\",\"labelValue\":\"民生\",\"score\":28.89},{\"labelName\":\"播出平台\",\"labelValue\":\"网络\",\"score\":23.33},{\"labelName\":\"内容类型\",\"labelValue\":\"国内社会\",\"score\":21.11},{\"labelName\":\"报道地区\",\"labelValue\":\"其他\",\"score\":20},{\"labelName\":\"播出平台\",\"labelValue\":\"东方卫视\",\"score\":15.56},{\"labelName\":\"报道地区\",\"labelValue\":\"内地\",\"score\":15.56},{\"labelName\":\"名栏\",\"labelValue\":\"上海早晨\",\"score\":15.56},{\"labelName\":\"播出平台\",\"labelValue\":\"地方台,上海新闻综合\",\"score\":14.44}],\"recommendation\":[{\"label\":\"社会\",\"score\":46.81},{\"label\":\"国际\",\"score\":21.28},{\"label\":\"科技\",\"score\":12.77},{\"label\":\"时政\",\"score\":10.64},{\"label\":\"历史\",\"score\":4.26},{\"label\":\"军事\",\"score\":4.26}],\"score\":92.78},{\"catName\":\"娱乐\",\"items\":[{\"labelName\":\"内容类型\",\"labelValue\":\"明星动态\",\"score\":100},{\"labelName\":\"人物\",\"labelValue\":\"王宝强\",\"score\":100}],\"recommendation\":[],\"score\":2.06},{\"catName\":\"原创\",\"items\":[{\"labelName\":\"内容类型\",\"labelValue\":\"吐槽\",\"score\":100},{\"labelName\":\"播出年代\",\"labelValue\":\"2016\",\"score\":50}],\"recommendation\":[],\"score\":2.06},{\"catName\":\"电影\",\"items\":[{\"labelName\":\"编剧\",\"labelValue\":\"鲍德熹\",\"score\":100},{\"labelName\":\"上映时间\",\"labelValue\":\"2015-02-19\",\"score\":100},{\"labelName\":\"内容类型\",\"labelValue\":\"奇幻\",\"score\":100},{\"labelName\":\"播出年代\",\"labelValue\":\"2015\",\"score\":100},{\"labelName\":\"主演\",\"labelValue\":\"吉克隽逸\",\"score\":100},{\"labelName\":\"导演\",\"labelValue\":\"鲍德熹\",\"score\":100},{\"labelName\":\"电影形式\",\"labelValue\":\"长片\",\"score\":100},{\"labelName\":\"所属片名\",\"labelValue\":\"钟馗伏魔：雪妖魔灵\",\"score\":100}],\"recommendation\":[],\"score\":1.03},{\"catName\":\"电视剧\",\"items\":[{\"labelName\":\"播出年代\",\"labelValue\":\"2016\",\"score\":100},{\"labelName\":\"播出平台\",\"labelValue\":\"东方卫视,北京卫视\",\"score\":100},{\"labelName\":\"首播时间\",\"labelValue\":\"2016-09-07\",\"score\":100},{\"labelName\":\"编剧\",\"labelValue\":\"张蕾\",\"score\":100},{\"labelName\":\"所属片名\",\"labelValue\":\"中国式关系\",\"score\":100},{\"labelName\":\"主演\",\"labelValue\":\"陈建斌\",\"score\":100},{\"labelName\":\"语言\",\"labelValue\":\"国语\",\"score\":100},{\"labelName\":\"导演\",\"labelValue\":\"沈严\",\"score\":100},{\"labelName\":\"内容类型\",\"labelValue\":\"都市\",\"score\":100}],\"recommendation\":[{\"label\":\"影视\",\"score\":100}],\"score\":1.03},{\"catName\":\"体育\",\"items\":[{\"labelName\":\"项目\",\"labelValue\":\"综合体坛\",\"score\":100}],\"recommendation\":[],\"score\":1.03}],\"id\":\"681274129\"},\"success\":true}";
		JSONObject map = JSON.parseObject(text);
		userTag = JSON.parseObject(map.get("root").toString(), UserTag.class);
		userTag.setStart(start);;
		userTag.setLimit(limit);;
		userTag.setCtVer(ctVer);
		userTag.setPrdType(prdType);
		
		System.out.println(userTag);
		JSON.toJSONString(userTag);
	}
}