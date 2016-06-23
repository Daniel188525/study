package com.siebre.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.siebre.entity.User;
import com.siebre.web.validated.UserValidator;

@Controller
public class UserController extends BaseController {
	
	@InitBinder
	public void initBinder(DataBinder binder) {
		//添加一个日期类型编辑器，也就是需要日期类型的时候，怎么把字符串转化为日期类型  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ModelAndView jsonTest() {
		log.debug("jsontest view");
		ModelAndView view = new ModelAndView();
		view.addObject("message", "hello world!");
		view.setViewName("jqueryAjax");
		return view;
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	/**
	 * 接收表单提交信息并校验其信息
	 * user property binding denpency input name
	 * @param user
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")  
    public String login(@Validated User user, BindingResult result, HttpServletRequest request) {  
       if (result.hasErrors()) {
    	   log.debug("BindingResult Errors size is " + result.getAllErrors().size());
    	   return "user/error"; //redirect:重定向会找对应的controller-requestMapping
       }
       
       request.getSession().setAttribute("user", user);
       
       return "redirect:/welcome";  
    }
	
	/**
	 * 接收ajax get req 获取某些信息--返回json信息
	 * @return json
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody
	User getUser() {
		User user = new User();
		user.setId(new Long(11212));
		user.setName("Daniel");
		user.setAge(27);
		return user;
	}
}
