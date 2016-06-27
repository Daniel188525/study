package com.siebre.restcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.siebre.entity.User;

/**
 * 
 * @ClassName: UserController
 * @Description: 
 * @author ZhaoHongshuai
 * @date 2016-5-25 ÏÂÎç2:47:43
 * @version 1.0
 */
@RestController  
@RequestMapping("/user") 
public class UserRestController {

	@RequestMapping("/{id}")  
    public ModelAndView view(@PathVariable("id") Long id, HttpServletRequest req) {  
        User user = new User();  
        user.setId(id);  
        user.setName("zhang");  
  
        ModelAndView mv = new ModelAndView();  
        mv.addObject("user", user);  
        mv.setViewName("user/login.jsp");  
        return mv;  
    }
	
}
