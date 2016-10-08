package com.wondertek.mobilevideo.core.recommend;

import java.io.FileNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.wondertek.mobilevideo.core.base.Constants;
import com.wondertek.mobilevideo.core.recommend.cache.SystemConfigCache;
import com.wondertek.mobilevideo.core.recommend.dao.SystemConfigDao;

import junit.framework.TestCase;
/**
 * 单元测试基类
 * @author chyx
 */
public class BaseTestCase extends TestCase {
	
	static {  
        try {  
            Log4jConfigurer.initLogging("classpath:log4j.xml");  
        } catch (FileNotFoundException ex) {  
            System.err.println("Cannot Initialize log4j");  
        }  
    }
	
	@Override
	protected void setUp() throws Exception {
		String[] apps = new String[] {
				"classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-mongodb.xml",
				"classpath:/applicationContext-mongodb-service.xml",
				"classpath*:/applicationContext-recommend-service.xml",
				"classpath*:/applicationContext-recommend-dao.xml"
				};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(apps);
		Constants.ctx = ctx;
		SystemConfigDao systemConfigDao = (SystemConfigDao)Constants.ctx.getBean("systemConfigDao");
		SystemConfigCache.init(systemConfigDao);
		super.setUp();
	}
}
