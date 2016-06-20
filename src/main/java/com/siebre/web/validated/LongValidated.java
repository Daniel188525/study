package com.siebre.web.validated;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LongValidated implements Validator{

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", null, "id is empty");
		try {
			Long id = (Long) target;
		} catch (Exception e) {
			errors.rejectValue("id", target.toString(), "input id is not effective, please input longType");
		}
		
	}

}
