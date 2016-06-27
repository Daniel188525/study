package com.siebre.service;

public class BaseService {

	public BaseService(String url) {
		System.out.println("baseService dataBaseUrl is " + url);
	}
	
	public void process() {
		System.out.println("BaseService.process");
	}
}
