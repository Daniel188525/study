package com.siebre.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloWorld implements BeanNameAware, BeanFactoryAware,
		BeanPostProcessor, InitializingBean, DisposableBean {

	private String hello;

	public void setBeanName(String arg0) {
		System.out.println("����BeanNameAware��setBeanName()...");
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
		System.out.println("����setHello()...");
	}
	
	public void customInit() {
		System.out.println("����customInit()...");
	}

	public void customDestroy() {
		System.out.println("����customDestroy()...");
	}

	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out
				.println("����BeanPostProcessor��postProcessAfterInitialization()...");
		return null;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out
				.println("����BeanPostProcessor��postProcessBeforeInitialization()...");
		return null;
	}

	public void destroy() throws Exception {
		System.out.println("����DisposableBean��destory()...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("����InitializingBean��afterPropertiesSet()...");
	}

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("����BeanFactoryAware��setBeanFactory()...");
	}

}
