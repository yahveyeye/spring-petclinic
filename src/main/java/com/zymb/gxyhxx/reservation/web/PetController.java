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
package com.zymb.gxyhxx.reservation.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.service.ClinicService;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/reservation")
public class PetController {

    private final ClinicService clinicService;

    @Autowired
    public PetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @InitBinder("reservation")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PetValidator());
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreationForm( ModelMap model) {
    	Reservation pet = new Reservation();
        model.put("reservation", pet);
        return "reservation/createOrUpdateReservationForm";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreationForm( @Valid Reservation reservation, BindingResult result, ModelMap model) {
        String idCardNo = reservation.getIdCardNo();
		if (StringUtils.hasLength(idCardNo) && reservation.isNew() && clinicService.findReservationByIdCardNo(idCardNo) != null){
            result.rejectValue("idCardNo", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.put("reservation", reservation);
            return "reservation/createOrUpdateReservationForm";
        } else {
            this.clinicService.saveReservation(reservation);
            return "redirect:/reservation/"+ reservation.getId();
        }
    }

    /**
     * Custom handler for displaying an reservation.
     *
     * @param reservationId the ID of the reservation to display
     * @return a ModelMap with the model attributes for the view
     */
    @RequestMapping("/{reservationId}")
    public ModelAndView showReservation(@PathVariable("reservationId") int reservationId) {
        ModelAndView mav = new ModelAndView("reservations/reservationDetails");
        mav.addObject(this.clinicService.findReservationById(reservationId));
        return mav;
    }

}
