package com.siebre.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.siebre.config.AppConfig;
import com.siebre.config.MvcConfig;
  
public class WebInitializer implements WebApplicationInitializer {  
  
    public void onStartup(javax.servlet.ServletContext sc) throws ServletException {  
  
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();  
        rootContext.register(AppConfig.class);  
        sc.addListener(new ContextLoaderListener(rootContext));  
  
        //2°¢springmvc…œœ¬Œƒ  
        AnnotationConfigWebApplicationContext springMvcContext = new AnnotationConfigWebApplicationContext();  
        springMvcContext.register(MvcConfig.class);  
        //3°¢DispatcherServlet  
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springMvcContext);  
        ServletRegistration.Dynamic dynamic = sc.addServlet("dispatcherServlet", dispatcherServlet);  
        dynamic.setLoadOnStartup(1);  
        dynamic.addMapping("/");  
  
        //4°¢CharacterEncodingFilter  
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();  
        characterEncodingFilter.setEncoding("utf-8");  
        FilterRegistration filterRegistration =  
                sc.addFilter("characterEncodingFilter", characterEncodingFilter);  
        filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");  
  
    }  
}
