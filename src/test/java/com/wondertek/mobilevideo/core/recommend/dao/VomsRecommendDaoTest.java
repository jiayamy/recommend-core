package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.List;

import org.junit.Test;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.BaseTestCase;
import com.wondertek.mobilevideo.core.recommend.vo.VomsRecommendVo;

public class VomsRecommendDaoTest extends BaseTestCase{

	@Test
	public void testSerialListCount() {
		VomsRecommendDao dao = (VomsRecommendDao)Constants.ctx.getBean("vomsRecommendDao");
		List<VomsRecommendVo> vos=dao.getVomsRecommendVos(null, "MIGUVIDEO", "电影");
		assertNull(vos);
	}
}
