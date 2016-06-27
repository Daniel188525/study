package com.siebre.config;

import org.springframework.beans.factory.annotation.Value;
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
@Import({ PropertySourceConfig.class, DatabaseConfig.class, JobConfig.class, MyViewResolverConfig.class })
public class AppConfig {
	
	/**
	 * ${format.config.date} 在JAVA类中不能存在空格，否则会出现无法解析问题；XML注入可以存在空格
	 * @param url
	 * @return
	 */
	@Bean
	BaseService baseService(@Value("${database.url}") String url) {
		return new BaseService(url);
	}
}
