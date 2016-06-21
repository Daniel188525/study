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
        //���һ���������ͱ༭����Ҳ������Ҫ�������͵�ʱ����ô���ַ���ת��Ϊ��������  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
        //���һ��spring�Դ���validator  
        binder.setValidator(new StudentValidator());  
    }  
      
    /* 
     * �Ὣһ���µ�Student���ӵ�modelattribute�У�����Ϊst2,����ͼ�п���ʹ��,Ҳ��������ڱ༭ҳ�� 
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
