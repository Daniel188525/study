package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:/config/application-dataSource.xml" })
public class DatabaseConfig {
}
