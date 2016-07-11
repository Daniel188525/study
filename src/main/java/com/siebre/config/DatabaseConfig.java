package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * 
 * @ClassName: DatabaseConfig
 * @Description: init database
 * @author ZhaoHongshuai
 * @date Jul 11, 2016 10:35:19 AM
 * @version 1.0
 */
@Configuration
@ImportResource({ "classpath:/config/application-dataSource.xml" })
public class DatabaseConfig {
}
