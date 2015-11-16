package com.zymb.gxyhxx.reservation.web;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.service.ClinicService;
import com.zymb.gxyhxx.reservation.service.ClinicServiceImpl;

public class ReservationValidator extends LocalValidatorFactoryBean implements Validator {

	private ClinicService clinicService;

	public ReservationValidator(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	private boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Reservation.class.equals(clazz);

	}

	@Override
	public void validate(Object obj, Errors errors) {
		Reservation reservation = (Reservation) obj;
		String personName = reservation.getPersonName();
		String idCardNo = reservation.getIdCardNo();
		String email = reservation.getEmail();
		String phone = reservation.getPhone();
		String qq = reservation.getQq();

		// personName validator
		if (personName.equals(null) || personName.equals("")) {
			errors.rejectValue("personName", null, "姓名不能为空");
		}
		// idCardNo validator
		if(idCardNo.equals(null) || idCardNo.equals("")) {
			errors.rejectValue("idCardNo", null, "身份证不能为空");
		}else if(!match("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$",idCardNo)){
			errors.rejectValue("idCardNo", null, "身份证格式不对");
		}
		else {

			Collection<Reservation> results = this.clinicService.findReservationByIdCardNo(reservation.getIdCardNo());
			if (results.size() == 1) {
				errors.rejectValue("idCardNo", null, "该身份证号已预约");
			}
		}
		// email validator
		if(email.equals(null) || email.equals("")) {
			errors.rejectValue("email", null, "电子邮箱不能为空");
		}else if(!match("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",email)){
			errors.rejectValue("email", null, "电子邮箱格式不对");
		}
		
		//phone validator
		if(phone.equals(null) || phone.equals("")) {
			errors.rejectValue("phone", null, "手机号不能为空");
		}else if(!match("^1[3-8]+\\d{9}",email)){
			errors.rejectValue("phone", null, "手机号格式不对");
		}
		//qq validator
		if(qq.equals(null) || qq.equals("")) {
			errors.rejectValue("qq", null, "手机号不能为空");
		}

	}

}
