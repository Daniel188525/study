package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = { "classpath:/config/application-velocity.xml" })
public class VelocityConfig {

	/*@Bean
	VelocityConfigurer velocityConfigurer(
			@Value("${spring.velocity.resourceLoaderPath}") String resourceLoaderPath,
			@Value("${spring.velocity.configLocation}") String filePatch) {
		VelocityConfigurer configurer = new VelocityConfigurer();
		configurer.setResourceLoaderPath(resourceLoaderPath);
		configurer.setConfigLocation(new FileSystemResource(filePatch));
		return configurer;
	}*/
}
