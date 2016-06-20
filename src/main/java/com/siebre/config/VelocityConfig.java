package com.siebre.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

@Configuration
public class VelocityConfig {

	@Bean
	VelocityConfigurer velocityConfigurer(
			@Value("spring.velocity.resourceLoaderPath") String resourceLoaderPath,
			@Value("spring.velocity.configLocation") String filePatch) {
		VelocityConfigurer configurer = new VelocityConfigurer();
		configurer.setResourceLoaderPath(resourceLoaderPath);
		configurer.setConfigLocation(new FileSystemResource(filePatch));
		return configurer;
	}
}
