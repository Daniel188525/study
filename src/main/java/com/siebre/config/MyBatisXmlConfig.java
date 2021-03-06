package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ 
	"classpath:/config/application-mybatis-config.xml" 
	})
@Import({ 
	SpringMyBatisIntegrationConfig.class 
	})
public class MyBatisXmlConfig {
}
