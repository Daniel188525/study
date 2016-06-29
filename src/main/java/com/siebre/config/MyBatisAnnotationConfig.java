package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * mybatisע����ʽ--С��Ŀ ������ ����
 * @author daniel.zhao
 *
 */
@Configuration
@ImportResource({ 
	"classpath:/config/application-mybatis-mapper.xml" 
	})
public class MyBatisAnnotationConfig {
}
