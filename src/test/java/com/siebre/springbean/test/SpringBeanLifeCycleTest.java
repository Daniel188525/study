package com.siebre.springbean.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.siebre.bean.HelloWorld;
import com.siebre.bean.PostProcessorBean;
import com.siebre.config.SpringBeanConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringBeanConfig.class })
public class SpringBeanLifeCycleTest {

	@Autowired
	private ApplicationContext context;
	
	//@Autowired
	private HelloWorld helloWorld;
	
	//@Test
	public void test() throws Exception {
		assertEquals("hello world!", helloWorld.getHello());   
		helloWorld.destroy(); 
	}
	
	@Test
	public void testProcessor() {
		PostProcessorBean postProcessorBean = (PostProcessorBean)context.getBean("postProcessorBean");
		System.out.println("---------------testProcessor----------------");  
        System.out.println("username:" + postProcessorBean.getUsername());  
        System.out.println("password:" + postProcessorBean.getPassword());
	}
}
