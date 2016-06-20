package com.siebre.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SpringQuartzMemory extends QuartzJobBean {

	private static int counter = 0;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		long ms = System.currentTimeMillis();
		System.out.println("SpringQuartzMemory...(" + counter++ + ") " + new Date(ms));
	}

}
