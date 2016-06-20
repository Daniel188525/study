package com.siebre.job;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class SpringSheduleJob {

	@Scheduled(fixedRate = 2000)
	public void printString() {
		System.out.println("SpringSheduleJob.printString......" + new Date() + ", thread id is " + Thread.currentThread().getId());
	}
}
