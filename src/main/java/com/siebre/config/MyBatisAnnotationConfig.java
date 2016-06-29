package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * mybatis注解形式--小项目 轻量级 清晰
 * @author daniel.zhao
 *
 */
@Configuration
@ImportResource({ 
	"classpath:/config/application-mybatis-mapper.xml" 
	})
public class MyBatisAnnotationConfig {
}
