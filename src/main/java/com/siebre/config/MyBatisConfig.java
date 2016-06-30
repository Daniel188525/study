package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ 
//	MyBatisAnnotationConfig.class
//	,
	MyBatisXmlConfig.class
	})
public class MyBatisConfig {
}
