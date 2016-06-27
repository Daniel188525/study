package com.siebre.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.siebre.entity.User;
import com.siebre.web.validated.UserValidator;

@Controller
public class TestController extends BaseController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//添加一个日期类型编辑器，也就是需要日期类型的时候，怎么把字符串转化为日期类型 
		log.info("TestController initBinder......");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
        //添加一个spring自带的validator  
        binder.setValidator(new UserValidator());
	}
	
	/**
	 * 调用@RequestMapping的方法之前,为request对象的model里put("user",user)
	 * @return
	 */
	@ModelAttribute
	public User addUser() {
		User user = new User();
		user.setId(new Long("84521878"));
		user.setName("Daniel");
		return user;
	}
	
	@RequestMapping("/test1")  
    public String test1(@CookieValue("JSESSIONID") String cookie, Model model) {
		log.debug("test1, cookie=" + cookie);
        return "test";  
    }  
  
    @RequestMapping("/test2")  
    public String test2(@RequestParam Long id, @RequestParam String name, Model model) {
        model.addAttribute("id", id);  
        model.addAttribute("name", name);
        try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "test";  
    }
    
    @RequestMapping("/testUpload")
    public String testUploadFile(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
    	log.debug("uploadFile size is " + uploadFile.getSize());
    	 return "test";  
    }
    
}
