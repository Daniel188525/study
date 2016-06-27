package com.siebre.controller;

import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.validation.Valid;  
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.springframework.beans.propertyeditors.CustomDateEditor;  
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.WebDataBinder;  
import org.springframework.web.bind.annotation.InitBinder;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

import com.siebre.entity.Student;
import com.siebre.web.validated.StudentValidator;
  
@Controller  
public class StudentController {  
    protected final Log logger = LogFactory.getLog(getClass());  
      
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        //添加一个日期类型编辑器，也就是需要日期类型的时候，怎么把字符串转化为日期类型  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
        //添加一个spring自带的validator  
        binder.setValidator(new StudentValidator());  
    }  
      
    /* 
     * 会将一个新的Student增加到modelattribute中，名字为st2,在视图中可以使用,也许可以用在编辑页面 
    @ModelAttribute("st2") 
    public Student getStudent(){ 
        System.out.println("In modelAttribute"); 
        Student re = new Student(); 
        re.setName("Haha"); 
        re.setAge(30); 
        re.setGender("male"); 
        return re; 
    } 
    */  
      
    @RequestMapping(value="/get",method=RequestMethod.GET)  
    public ModelAndView get(Student t) {  
        if(t.getId() > 0) {
        	
        }  
        t.setBirthday(new Date());  
        return new ModelAndView("edit");  
    }  
      
    @RequestMapping(value="/studentAdd")  
    public ModelAndView studentAdd(@Valid @ModelAttribute Student student, BindingResult br, HttpServletRequest requset){  
        System.out.println(student);      
        if(br.hasErrors()) {  
                System.out.println(br);  
                return new ModelAndView("edit");  
            }  
        System.out.println(br);  
            return new ModelAndView("aa");  
    }  
} 
