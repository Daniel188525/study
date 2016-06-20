package com.siebre.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.siebre.service.BaseService;

public class SpringQuartzDB extends QuartzJobBean {

	private BaseService baseService;
	
	private static int counter = 0;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		long ms = System.currentTimeMillis();
		System.out.println("SpringQuartzDB...(" + counter++ + ") " + new Date(ms));
	}

}
