package com.siebre.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.siebre.entity.UserDetails;
import com.siebre.web.validated.LongValidated;

@RestController
public class SpringRestControllerDemo {

	@RequestMapping(value = "/springcontent/{id}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public UserDetails getUser(
			@PathVariable("id") @Validated(value = { LongValidated.class }) Long id) {
		UserDetails userDetails = new UserDetails();
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