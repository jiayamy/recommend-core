package com.wondertek.mobilevideo.core.recommend.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSON;
import com.wondertek.mobilevideo.core.recommend.mongo.model.UserTag;

public class UserTagService {
	public static final String _ID = "id";
	public static final String COLLECTION_NAME = "recomm_user_tag";
	@Autowired  
	MongoTemplate mongoTemplate;
	/**
	 * 测试的时候新增数据
	 * @param id
	 */
	public void insert(String id) {
		String text = "{\"id\":\""+id+"\",\"cats\":[{\"catName\":\"电影\",\"score\":1.03,\"recommendation\":[],\"items\":[{\"labelName\":\"编剧\",\"labelValue\":\"鲍德熹\",\"score\":100},{\"labelName\":\"上映时间\",\"labelValue\":\"2015-02-19\",\"score\":100},{\"labelName\":\"内容类型\",\"labelValue\":\"奇幻\",\"score\":100},{\"labelName\":\"播出年代\",\"labelValue\":\"2015\",\"score\":100},{\"labelName\":\"主演\",\"labelValue\":\"吉克隽逸\",\"score\":100},{\"labelName\":\"导演\",\"labelValue\":\"鲍德熹\",\"score\":100},{\"labelName\":\"电影形式\",\"labelValue\":\"长片\",\"score\":100},{\"labelName\":\"所属片名\",\"labelValue\":\"钟馗伏魔：雪妖魔灵\",\"score\":100}]},{\"catName\":\"电视剧\",\"score\":1.03,\"recommendation\":[{\"label\":\"影视\",\"score\":100}],\"items\":[{\"labelName\":\"播出年代\",\"labelValue\":\"2016\",\"score\":100},{\"labelName\":\"播出平台\",\"labelValue\":\"东方卫视,北京卫视\",\"score\":100},{\"labelName\":\"首播时间\",\"labelValue\":\"2016-09-07\",\"score\":100},{\"labelName\":\"编剧\",\"labelValue\":\"张蕾\",\"score\":100},{\"labelName\":\"所属片名\",\"labelValue\":\"中国式关系\",\"score\":100},{\"labelName\":\"主演\",\"labelValue\":\"陈建斌\",\"score\":100},{\"labelName\":\"语言\",\"labelValue\":\"国语\",\"score\":100},{\"labelName\":\"导演\",\"labelValue\":\"沈严\",\"score\":100},{\"labelName\":\"内容类型\",\"labelValue\":\"都市\",\"score\":100}]},{\"catName\":\"娱乐\",\"score\":2.06,\"recommendation\":[],\"items\":[{\"labelName\":\"内容类型\",\"labelValue\":\"明星动态\",\"score\":100},{\"labelName\":\"人物\",\"labelValue\":\"王宝强\",\"score\":100}]},{\"catName\":\"体育\",\"score\":1.03,\"recommendation\":[],\"items\":[{\"labelName\":\"项目\",\"labelValue\":\"综合体坛\",\"score\":100}]},{\"catName\":\"原创\",\"score\":2.06,\"recommendation\":[],\"items\":[{\"labelName\":\"内容类型\",\"labelValue\":\"吐槽\",\"score\":100},{\"labelName\":\"播出年代\",\"labelValue\":\"2016\",\"score\":50}]},{\"catName\":\"新闻\",\"score\":92.78,\"recommendation\":[{\"label\":\"历史\",\"score\":4.26},{\"label\":\"国际\",\"score\":21.28},{\"label\":\"时政\",\"score\":10.64},{\"label\":\"科技\",\"score\":12.77},{\"label\":\"社会\",\"score\":46.81},{\"label\":\"军事\",\"score\":4.26}],\"items\":[{\"labelName\":\"名栏\",\"labelValue\":\"东方大头条\",\"score\":1.11},{\"labelName\":\"播出平台\",\"labelValue\":\"东方卫视\",\"score\":15.56},{\"labelName\":\"内容类型\",\"labelValue\":\"军事\",\"score\":3.33},{\"labelName\":\"报道地区\",\"labelValue\":\"日本\",\"score\":1.11},{\"labelName\":\"内容类型\",\"labelValue\":\"独家数据\",\"score\":3.33},{\"labelName\":\"报道地区\",\"labelValue\":\"北京\",\"score\":7.78},{\"labelName\":\"报道地区\",\"labelValue\":\"山东\",\"score\":5.56},{\"labelName\":\"名栏\",\"labelValue\":\"看东方\",\"score\":4.44},{\"labelName\":\"报道地区\",\"labelValue\":\"四川\",\"score\":1.11},{\"labelName\":\"报道地区\",\"labelValue\":\"杭州\",\"score\":1.11},{\"labelName\":\"报道地区\",\"labelValue\":\"香港\",\"score\":3.33},{\"labelName\":\"内容类型\",\"labelValue\":\"人物\",\"score\":2.22},{\"labelName\":\"报道地区\",\"labelValue\":\"辽宁\",\"score\":2.22},{\"labelName\":\"报道地区\",\"labelValue\":\"其他\",\"score\":20},{\"labelName\":\"报道地区\",\"labelValue\":\"内地\",\"score\":15.56},{\"labelName\":\"播出平台\",\"labelValue\":\"上海新闻综合\",\"score\":1.11},{\"labelName\":\"内容类型\",\"labelValue\":\"时政\",\"score\":5.56},{\"labelName\":\"报道地区\",\"labelValue\":\"英国\",\"score\":2.22},{\"labelName\":\"报道地区\",\"labelValue\":\"浙江\",\"score\":2.22},{\"labelName\":\"报道地区\",\"labelValue\":\"意大利\",\"score\":1.11},{\"labelName\":\"报道形式\",\"labelValue\":\"短讯\",\"score\":87.78},{\"labelName\":\"报道地区\",\"labelValue\":\"海口\",\"score\":1.11},{\"labelName\":\"报道地区\",\"labelValue\":\"美国\",\"score\":7.78},{\"labelName\":\"播出平台\",\"labelValue\":\"卫视,东方卫视\",\"score\":2.22},{\"labelName\":\"名栏\",\"labelValue\":\"上海早晨\",\"score\":15.56},{\"labelName\":\"报道地区\",\"labelValue\":\"广东\",\"score\":2.22},{\"labelName\":\"报道地区\",\"labelValue\":\"菲律宾\",\"score\":1.11},{\"labelName\":\"报道地区\",\"labelValue\":\"国际\",\"score\":4.44},{\"labelName\":\"内容类型\",\"labelValue\":\"罪案\",\"score\":6.67},{\"labelName\":\"内容类型\",\"labelValue\":\"民生\",\"score\":28.89},{\"labelName\":\"内容类型\",\"labelValue\":\"国内社会\",\"score\":21.11},{\"labelName\":\"内容类型\",\"labelValue\":\"其它\",\"score\":1.11},{\"labelName\":\"报道地区\",\"labelValue\":\"俄罗斯\",\"score\":4.44},{\"labelName\":\"内容类型\",\"labelValue\":\"国际社会\",\"score\":4.44},{\"labelName\":\"报道地区\",\"labelValue\":\"叙利亚\",\"score\":2.22},{\"labelName\":\"播出平台\",\"labelValue\":\"地方台,上海新闻综合\",\"score\":14.44},{\"labelName\":\"语言\",\"labelValue\":\"国语\",\"score\":52.22},{\"labelName\":\"内容类型\",\"labelValue\":\"事故\",\"score\":5.56},{\"labelName\":\"名栏\",\"labelValue\":\"朝闻天下\",\"score\":1.11},{\"labelName\":\"内容类型\",\"labelValue\":\"科技\",\"score\":4.44},{\"labelName\":\"报道地区\",\"labelValue\":\"台湾\",\"score\":3.33},{\"labelName\":\"内容类型\",\"labelValue\":\"国内要闻\",\"score\":3.33},{\"labelName\":\"语言\",\"labelValue\":\"无\",\"score\":2.22},{\"labelName\":\"报道地区\",\"labelValue\":\"全国\",\"score\":2.22},{\"labelName\":\"播出平台\",\"labelValue\":\"网络\",\"score\":23.33},{\"labelName\":\"名栏\",\"labelValue\":\"新闻报道\",\"score\":8.89},{\"labelName\":\"报道地区\",\"labelValue\":\"江苏\",\"score\":1.11},{\"labelName\":\"报道地区\",\"labelValue\":\"泰国\",\"score\":2.22},{\"labelName\":\"内容类型\",\"labelValue\":\"国际要闻\",\"score\":8.89},{\"labelName\":\"报道地区\",\"labelValue\":\"土耳其\",\"score\":2.22}]}]}";
		com.wondertek.mobilevideo.core.recommend.vo.mongo.UserTag userTag = JSON.parseObject(text, com.wondertek.mobilevideo.core.recommend.vo.mongo.UserTag.class);
		UserTag saveTag = new UserTag();
		saveTag.setId(userTag.getId());
		saveTag.setCats(userTag.getCats());
		mongoTemplate.save(userTag,COLLECTION_NAME);
	} 
	/**
	 * 查询
	 * @param id
	 */
	public UserTag queryById(String id) {  
		// 根据age查询  
		List<UserTag> persons = mongoTemplate.find(new Query(new Criteria(_ID).is(id)), UserTag.class, COLLECTION_NAME);  
		if(persons != null && !persons.isEmpty()){
			return persons.get(0);
		}
		return null;
	}
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
}
