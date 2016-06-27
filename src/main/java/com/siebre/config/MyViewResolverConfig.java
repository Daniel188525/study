package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
@ImportResource({ "classpath:/config/application-viewResolver.xml" })
public class MyViewResolverConfig {

	@Bean
	BeanNameViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}
}
