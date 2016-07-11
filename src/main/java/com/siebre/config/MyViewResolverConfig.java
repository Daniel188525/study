package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.view.BeanNameViewResolver;

/**
 * 
 * 
 * @ClassName: MyViewResolverConfig
 * @Description: user-defined view resolver
 * @author ZhaoHongshuai
 * @date Jul 11, 2016 10:35:44 AM
 * @version 1.0
 */
@Configuration
@ImportResource({ "classpath:/config/application-viewResolver.xml" })
public class MyViewResolverConfig {

	@Bean
	BeanNameViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}
}
