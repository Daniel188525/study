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
		//���һ���������ͱ༭����Ҳ������Ҫ�������͵�ʱ����ô���ַ���ת��Ϊ��������  
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
	 * ���ձ��ύ��Ϣ��У������Ϣ
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
    	   return "user/error"; //redirect:�ض�����Ҷ�Ӧ��controller-requestMapping
       }
       
       request.getSession().setAttribute("user", user);
       
       return "redirect:/welcome";  
    }
	
	/**
	 * ����ajax get req ��ȡĳЩ��Ϣ--����json��Ϣ
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
