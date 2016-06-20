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
 * @Description: Job config--���ö�ʱ�� �ǵ�ʵ��
 * @author ZhaoHongshuai
 * @date 2016-5-11 ����10:57:13
 * @version 1.0
 */
public class JobExecutorConfig implements SchedulingConfigurer {

	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		
		//��ʹ�ø÷�ʽʱ����Ҫȥ��springSheduleJob().printString()�����ϵ�@Scheduled(fixedRate = 2000)
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
