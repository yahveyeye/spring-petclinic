package com.zymb.gxyhxx.reservation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


import com.zymb.gxyhxx.reservation.validator.IdCardNoUniqueValidator;

/** 
 * User: yanghaiqi 
 * 
 */  
  
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) 
@Constraint(validatedBy = IdCardNoUniqueValidator.class)  
@Documented
@Inherited

public @interface IdCardNoUnique {  
    String message() default "{idCardNo.not.unique}";  
    Class<?>[] groups() default {};  
    Class<? extends Payload>[] payload() default {};  
  
    
}  