package com.siebre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PartnerTransactionController {

	@RequestMapping(value = "/Policy/ProcessPartnerTransaction.jspx", method = RequestMethod.GET)
	public void process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test");
	}
}
