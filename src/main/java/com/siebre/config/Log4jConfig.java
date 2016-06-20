package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siebre.bean.MyLog4jConfigurer;

/**
 * init logging by annotation
 * @ClassName: Log4jConfig
 * @Description: 
 * @author ZhaoHongshuai
 * @date 2016-5-27 ионГ11:02:21
 * @version 1.0
 */
@Configuration
public class Log4jConfig {

	@Bean
	MyLog4jConfigurer myLog4jConfigurer() {
		return new MyLog4jConfigurer("classpath:config/log4j.properties");
	}
}
