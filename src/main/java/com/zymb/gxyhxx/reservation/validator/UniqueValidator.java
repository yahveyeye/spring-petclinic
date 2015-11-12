package com.zymb.gxyhxx.reservation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.zymb.gxyhxx.reservation.annotation.Unique;

public class UniqueValidator implements ConstraintValidator<Unique,String>{

	private String idCardNo;
	
	@Override
	public void initialize(Unique unique) {
		// TODO Auto-generated method stub
		this.idCardNo=unique.idCardNo();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

}
