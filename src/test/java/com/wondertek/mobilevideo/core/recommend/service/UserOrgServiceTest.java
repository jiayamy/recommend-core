package com.wondertek.mobilevideo.core.recommend.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.BaseTestCase;

/**
 *
 * UserOrgServiceTest
 *
 * Creator: donghanfang 2015-11-26
 *
 * @version 1.0.0
 */
public class UserOrgServiceTest extends BaseTestCase {
	@Test
	public void testGetOrgid() {
		SystemConfigService service = (SystemConfigService)Constants.ctx.getBean("systemConfigService");
		Map<String,Object> param = new HashMap<String,Object>();
		Long count = service.getConfigCount(param);
		assertTrue(count >= 0);
	}
}
