package com.yuan;

import com.yuan.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 *
 * 可以在测试期间
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01QuickApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
	Person p ;
    @Autowired
	ApplicationContext ioc;

	@Test
    public void testHelloService() {
        logger.info("");
        logger.warn("");
        logger.error("这是日志啊");
        Boolean b = ioc.containsBean("helloService");
		System.out.print(b);
	}




	//@Test
	public void contextLoads() {
		System.out.print("==========="+p.toString());
	}

}
