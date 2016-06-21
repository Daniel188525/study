package com.siebre.web.validated;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.siebre.entity.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");  
        ValidationUtils.rejectIfEmpty(errors, "gender", "null");  
        ValidationUtils.rejectIfEmpty(errors, "age", "null");  
        Student s = (Student)target;  
        if(s.getAge() < 18){  
        	errors.rejectValue("age","young");  
        }else if(s.getAge() > 50){  
        	errors.reject("age", "old");  
        }
        
        if(s.getName().length() < 1){ 
        	errors.reject("name", "short"); 
        }else if(s.getName().length() > 10){ 
        	errors.reject("name", "long"); 
        }
	}

}
