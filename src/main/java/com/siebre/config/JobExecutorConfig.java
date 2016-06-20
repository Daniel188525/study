package com.siebre.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.siebre.job.SpringSheduleJob;

/**
 * 
 * @ClassName: JobConfig
 * @Description: Job config--配置定时器 非单实例
 * @author ZhaoHongshuai
 * @date 2016-5-11 上午10:57:13
 * @version 1.0
 */
public class JobExecutorConfig implements SchedulingConfigurer {

	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		
		//当使用该方式时，需要去除springSheduleJob().printString()方法上的@Scheduled(fixedRate = 2000)
		/*taskRegistrar.addTriggerTask(new Runnable() {
			public void run() {
				springSheduleJob().printString();
			}

			},
			new CronTrigger("0/3 * * * * ?")
		);*/
	}

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(100);
	}

	@Bean
	SpringSheduleJob springSheduleJob() {
		return new SpringSheduleJob();
	}
}
