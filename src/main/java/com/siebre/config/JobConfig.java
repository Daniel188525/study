package com.siebre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.siebre.job.SpringSheduleJob;

/**
 * 
 * @ClassName: JobConfig
 * @Description: Job config--配置定时器 单实例
 * @author ZhaoHongshuai
 * @date 2016-5-11 上午10:57:13
 * @version 1.0
 */
@Configuration
@Import({ 
			/*QuartzJobMemory.class,*/
			/*QuartzJobDB.class*/
	   })
public class JobConfig {

	/*@Bean
	SpringSheduleJob springSheduleJob() {
		return new SpringSheduleJob();
	}*/
}
