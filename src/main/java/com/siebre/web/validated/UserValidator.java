package com.siebre.web.validated;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.siebre.entity.User;

public class UserValidator implements Validator {

	/*
	 * user id validator
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", null, "name is empty");
		User user = (User) target;
		if (StringUtils.isBlank(user.getName())) {
			errors.rejectValue("name", null, "name is empty.");
		}

	}

}
