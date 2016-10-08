package com.wondertek.mobilevideo.core.recommend.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.BaseTestCase;

public class SystemConfigDaoTest extends BaseTestCase{

	@Test
	public void testSerialListCount() {
		SystemConfigDao dao = (SystemConfigDao)Constants.ctx.getBean("systemConfigDao");
		Map<String,Object> param = new HashMap<String,Object>();
		Long count = dao.getConfigCount(param);
		assertTrue(count >= 0);
	}
}
