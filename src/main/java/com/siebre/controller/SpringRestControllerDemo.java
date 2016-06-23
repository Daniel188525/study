package com.siebre.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.siebre.entity.UserDetails;

@RestController
public class SpringRestControllerDemo {

	@RequestMapping(value = "/springcontent/{id}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public UserDetails getUser(@PathVariable("id") Long id) {
		UserDetails userDetails = new UserDetails(); //根据ID从DB load 对应数据
		userDetails.setId(id);
		userDetails.setUserName("zhaohongshuai");
		userDetails.setEmail("Daniel@gmail.com");
		return userDetails;
	}

	@RequestMapping(value = "/springcontent.htm", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getUserHtml() {
		// Test HTML view
		return "example";
	}
}
