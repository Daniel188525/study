package com.siebre.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BaseBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		// BeanFactoryPostProcessor�����޸�BEAN��������Ϣ��BeanPostProcessor����
		// �����������޸�postProcessorBean��usernameע������
		BeanDefinition bd = beanFactory.getBeanDefinition("postProcessorBean");
		MutablePropertyValues pv = bd.getPropertyValues();
		if (pv.contains("username")) {
			pv.addPropertyValue("username", "xiaojun");
		}
	}

}
