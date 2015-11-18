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
public class ReservationValidator implements Validator {

	

	public static boolean match(String regex, String str) {
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
			errors.rejectValue("personName", "required", "不能为空");
		}
		// idCardNo validator
		if(idCardNo.equals(null) || idCardNo.equals("")) {
			errors.rejectValue("idCardNo", "required", "不能为空");
		}else if(!match("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)",idCardNo)){
			errors.rejectValue("idCardNo",null, "身份证号格式不对");
		}
		
		// email validator
		if(email.equals(null) || email.equals("")) {
			errors.rejectValue("email","required", "不能为空");
		}else if(!match("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",email)){
			errors.rejectValue("email", null, "电子邮箱格式不对");
		}
		
		//phone validator
		if(phone.equals(null) || phone.equals("")) {
			errors.rejectValue("phone", "required", "不能为空");
		}else if(!match("^1[3-8]+\\d{9}",phone)){
			errors.rejectValue("phone", null, "手机号格式不对");
		}
		//qq validator
		if(qq.equals(null) || qq.equals("")) {
			errors.rejectValue("qq", "required", "不能为空");
		}else if(!match("^\\d{4,12}$",qq)){
			errors.rejectValue("qq", null, "qq号格式不对");
		}

	}

}
