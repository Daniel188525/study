package com.siebre.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 
 * @ClassName: MvcConfig
 * @Description: Scan packages[com.siebre.controller,com.siebre.restcontroller]
 * @author ZhaoHongshuai
 * @date 2016-5-12 ÉÏÎç9:19:30
 * @version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.siebre.controller", "com.siebre.restcontroller" }, useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class, RestController.class }) })
public class MvcConfig extends WebMvcConfigurationSupport {

	/*@Bean  
    public ViewResolver viewResolver() {  
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  
        viewResolver.setPrefix("/WEB-INF/view/");  
        viewResolver.setSuffix(".jsp");  
        return viewResolver;  
    }*/
}
