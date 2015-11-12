package com.zymb.gxyhxx.reservation.annotation;

import javax.validation.Constraint;  
import javax.validation.Payload;

import com.zymb.gxyhxx.reservation.validator.UniqueValidator;

import java.lang.annotation.*;

/** 
 * User: yanghaiqi 
 * 
 */  
  
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Constraint(validatedBy = UniqueValidator.class)  
@Documented  
public @interface Unique {  
    String message() default "{idCardNo.not.unique}";  
    Class<?>[] groups() default {};  
    Class<? extends Payload>[] payload() default {};  
  
    String idCardNo();  
    
}  