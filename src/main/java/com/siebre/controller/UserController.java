package com.siebre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siebre.entity.User;
import com.siebre.web.validated.UserValidator;

@Controller
public class UserController {

	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/login")  
    public String login(@Valid User user, BindingResult result, HttpServletRequest request) {  
       if (result.hasErrors())  
           return "redirect:user/login";
       
       request.getSession().setAttribute("user", user);
       
       return "redirect:/welcome";  
    }
}
