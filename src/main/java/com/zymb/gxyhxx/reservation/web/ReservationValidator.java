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
			errors.rejectValue("personName", null, "濮撳悕涓嶈兘涓虹┖");
		}
		// idCardNo validator
		if(idCardNo.equals(null) || idCardNo.equals("")) {
			errors.rejectValue("idCardNo", null, "韬唤璇佷笉鑳戒负绌�");
		}else if(!match("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$",idCardNo)){
			errors.rejectValue("idCardNo", null, "韬唤璇佹牸寮忎笉瀵�");
		}
		
		// email validator
		if(email.equals(null) || email.equals("")) {
			errors.rejectValue("email", null, "鐢靛瓙閭涓嶈兘涓虹┖");
		}else if(!match("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",email)){
			errors.rejectValue("email", null, "鐢靛瓙閭鏍煎紡涓嶅");
		}
		
		//phone validator
		if(phone.equals(null) || phone.equals("")) {
			errors.rejectValue("phone", null, "鎵嬫満鍙蜂笉鑳戒负绌�");
		}else if(!match("^1[3-8]+\\d{9}",email)){
			errors.rejectValue("phone", null, "鎵嬫満鍙锋牸寮忎笉瀵�");
		}
		//qq validator
		if(qq.equals(null) || qq.equals("")) {
			errors.rejectValue("qq", null, "鎵嬫満鍙蜂笉鑳戒负绌�");
		}

	}

}
