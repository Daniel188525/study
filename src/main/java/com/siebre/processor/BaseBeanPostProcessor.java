package com.siebre.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.siebre.bean.PostProcessorBean;

public class BaseBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// �����PostProcessorBean��username��Ϣ
		if (bean instanceof PostProcessorBean) {
			System.out.println("PostProcessorBean Bean initialized");
			PostProcessorBean pb = (PostProcessorBean) bean;

			System.out.println("username:" + pb.getUsername());
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof PostProcessorBean) {
			System.out.println("PostProcessorBean Bean initializing");
			PostProcessorBean pb = (PostProcessorBean) bean;

			System.out.println("username:" + pb.getUsername());
		}
		return bean;
	}

}
