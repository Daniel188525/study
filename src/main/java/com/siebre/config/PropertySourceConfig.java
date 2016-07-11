package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 
 * 
 * @ClassName: PropertySourceConfig
 * @Description: init properties files
 * @author ZhaoHongshuai
 * @date Jul 11, 2016 10:34:21 AM
 * @version 1.0
 */
@Configuration
@PropertySource(value = { 
		"classpath:config/jdbc.properties", 
		"classpath:config/bean-init.properties"
	})
public class PropertySourceConfig {

	@Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholder() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
