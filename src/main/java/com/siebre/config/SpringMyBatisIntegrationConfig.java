package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ 
	"classpath:/config/spring-mybatis-integration.xml" 
	})
public class SpringMyBatisIntegrationConfig {
}
