package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.siebre.service.BaseService;

/**
 * 
 * @ClassName: AppConfig
 * @Description: ������ʼ��������,���ڼ���һЩ��ʼ�������ļ�����ע���ʼ��bean
 * @author ZhaoHongshuai
 * @date 2016-5-11 ����10:25:10
 * @version 1.0
 */
@Configuration
@EnableScheduling
@ImportResource({ "classpath:/config/application-basic.xml" })
@Import({ DatabaseConfig.class, JobConfig.class })
public class AppConfig {
	@Bean
	BaseService baseService() {
		return new BaseService();
	}
}
