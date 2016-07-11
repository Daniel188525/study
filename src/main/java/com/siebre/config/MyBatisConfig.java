package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * 
 * @ClassName: MyBatisConfig
 * @Description: mybatis init config
 * @author ZhaoHongshuai
 * @date Jul 11, 2016 10:36:45 AM
 * @version 1.0
 */
@Configuration
@Import({ 
//	MyBatisAnnotationConfig.class
//	,
	MyBatisXmlConfig.class
	})
public class MyBatisConfig {
}
