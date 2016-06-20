package com.siebre.test;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.siebre.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class JobTest {
	
	@Test
	public void test() {
		System.out.println("Job test......" + new Date());

		/*try {
			System.in.read();// 按任意键退出
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}
}
