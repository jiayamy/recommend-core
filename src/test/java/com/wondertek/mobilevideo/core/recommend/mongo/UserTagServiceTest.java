package com.wondertek.mobilevideo.core.recommend.mongo;

import org.junit.Test;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.BaseTestCase;
import com.wondertek.mobilevideo.core.recommend.mongo.model.UserTag;
import com.wondertek.mobilevideo.core.recommend.mongo.service.UserTagService;

public class UserTagServiceTest extends BaseTestCase {
	@Test
	public void testGetOrgid() {
		UserTagService userTagService = (UserTagService) Constants.ctx.getBean("userTagService");
		int count = 681274129;
		for(count = 681274129 ; count < 681274140; count++){
			String id = ""+count;
//			userTagService.insert(id);
			UserTag userTag = userTagService.queryById(id);
			System.out.println(userTag.getId().toString());
			System.out.println(userTag);	
		}
	}
}
