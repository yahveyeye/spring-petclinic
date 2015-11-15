/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zymb.gxyhxx.reservation.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zymb.gxyhxx.reservation.model.Reservation;

/**
 * <code>Validator</code> for <code>Reservation</code> forms.
 * <p>
 * We're not using Bean Validation annotations here because it is easier to define such validation rule in Java.
 * </p>
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 */
public class ReservationValidator implements Validator {

    @Override
    public void validate(Object obj, Errors errors) {
        Reservation reservation = (Reservation) obj;
        String idCardNo = reservation.getIdCardNo();
        // name validation
        if (!StringUtils.hasLength(idCardNo)) {
            errors.rejectValue("idCardNo", "required", "required");
        }

    
    }

    /**
     * This Validator validates *just* Reservation instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Reservation.class.isAssignableFrom(clazz);
    }


}
