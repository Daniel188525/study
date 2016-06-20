package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.siebre.service.BaseService;

/**
 * 
 * @ClassName: AppConfig
 * @Description: 容器初始化加载类,用于加载一些初始化配置文件或者注入初始化bean
 * @author ZhaoHongshuai
 * @date 2016-5-11 上午10:25:10
 * @version 1.0
 */
@Configuration
@EnableScheduling
@ImportResource({ "classpath:/config/application-basic.xml" })
@Import({ DatabaseConfig.class, JobConfig.class })
public class AppConfig {
	@Bean
	BaseService baseService() {
		return new BaseService();
	}
}
