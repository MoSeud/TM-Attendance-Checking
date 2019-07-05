package com.redsea.mas.validator;

import com.redsea.mas.dto.TmCheckRetreatDto;
import com.redsea.mas.serviceImpl.TmCheckRetreatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class RetreatDateStudentValidator implements ConstraintValidator<RetreatDateStudent, TmCheckRetreatDto> {

	@Autowired
	private TmCheckRetreatService tmCheckRetreatService;

	@Override
	public boolean isValid(TmCheckRetreatDto value, ConstraintValidatorContext context) {
		return tmCheckRetreatService.checkDuplicate(value);
	}

}
