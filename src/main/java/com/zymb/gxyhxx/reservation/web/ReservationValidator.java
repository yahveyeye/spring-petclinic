package com.zymb.gxyhxx.reservation.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.service.ClinicService;


public class ReservationValidator extends LocalValidatorFactoryBean implements Validator {

	private final ClinicService clinicService;



    public ReservationValidator(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Reservation.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Reservation reservation = (Reservation) obj;
		super.validate(obj, errors);
        String idCardNo = reservation.getIdCardNo();
        // 验证唯一性
        if(idCardNo.length()>0){
        	
		    Reservation result = this.clinicService.findReservationByIdCardNo(reservation.getIdCardNo());
		    if (result == null) {
		    	errors.rejectValue("idCardNo", null,"该身份证号已预约");
		        }
        }
        else {
        	errors.rejectValue("idCardNo", null,"身份证号不能为空");
        }

	}

}
