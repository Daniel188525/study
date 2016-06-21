package com.siebre.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siebre.entity.User;
import com.siebre.web.validated.UserValidator;

@Controller
public class UserController extends BaseController {
	
	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/login")  
    public String login(@Validated User user, BindingResult result, HttpServletRequest request) {  
       if (result.hasErrors()) {
    	   log.debug("BindingResult Errors size is " + result.getAllErrors().size());
    	   return "user/error"; //redirect:重定向会找对应的controller-requestMapping
       }
       
       request.getSession().setAttribute("user", user);
       
       return "redirect:/welcome";  
    }
}
