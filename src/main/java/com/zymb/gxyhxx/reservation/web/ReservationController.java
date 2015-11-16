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

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.service.ClinicService;

/**
 * @author yuan lin
 */
@Controller
public class ReservationController {

	private final ClinicService clinicService;

	@Autowired
	public ReservationController(ClinicService clinicService) {
		this.clinicService = clinicService;

	}

	@InitBinder("reservation")
	public void initReservationBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new ReservationValidator());

	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");

	}

	@RequestMapping(value = "/reservations/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Reservation reservation = new Reservation();
		model.put("reservation", reservation);
		return "reservations/createOrUpdateReservationForm";
	}

	@RequestMapping(value = "/reservations/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Reservation reservation, BindingResult result, ModelMap model) {
		if (StringUtils.hasLength(reservation.getIdCardNo()) && reservation.isNew()
				&& clinicService.findReservationByIdCardNo(reservation.getIdCardNo()) != null) {
			result.rejectValue("IdCardNo", "duplicate", "already exists");
		}
		if (result.hasErrors()) {
			model.put("reservation", reservation);
			return "reservations/createOrUpdateReservationForm";
		} else {
			this.clinicService.saveReservation(reservation);
			return "redirect:/reservations/" + reservation.getId();
		}
	}

	// @RequestMapping(value = "/reservations/new", method = RequestMethod.POST)
	// public String processCreationForm(@Valid Reservation reservation,
	// BindingResult result, SessionStatus status) {
	// if (result.hasErrors()) {
	// return "reservations/createOrUpdateReservationForm";
	// } else {
	// this.clinicService.saveReservation(reservation);
	// status.setComplete();
	// return "redirect:/reservations/" + reservation.getId();
	// }
	// }

	@RequestMapping(value = "/reservations/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("reservation", new Reservation());
		return "reservations/findReservations";
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String processFindForm(Reservation reservation, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /reservations to return all
		// records
		// personName validator
		 if (reservation.getPersonName().equals(null) ||
		 reservation.getPersonName().equals("")) {
		 result.rejectValue("personName", "required", "不能为空");
		 }
		 // idCardNo validator
		 if (reservation.getIdCardNo().equals(null) ||
		 reservation.getIdCardNo().equals("")) {
		 result.rejectValue("idCardNo", "required", "不能为空");
		 } else if
		 (!ReservationValidator.match("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$",
		 reservation.getIdCardNo())) {
		 result.rejectValue("idCardNo", null, "身份证号格式不对");
		 }
		if (result.hasErrors()) {

			return "reservations/findReservations";
		} else {
			// find reservations by last name
			Collection<Reservation> results = this.clinicService
					.findReservationByIdCardNoAndPersonName(reservation.getIdCardNo(), reservation.getPersonName());
			if (results.isEmpty()) {
				// no reservations found
				result.rejectValue("idCardNo", "notFound", "not found");
				return "reservations/findReservations";
			} else if (results.size() == 1) {
				// 1 reservation found
				reservation = results.iterator().next();
				return "redirect:/reservations/" + reservation.getId();
			} else {
				// multiple reservations found
				model.put("selections", results);
				return "reservations/reservationsList";
			}
		}
	}

	@RequestMapping(value = "/reservations/list", method = RequestMethod.GET)
	public String processFindAll(Reservation reservation, BindingResult result, Map<String, Object> model) {
		Collection<Reservation> results = this.clinicService.findAllReservation();
		model.put("selections", results);
		return "reservations/reservationsList";
	}

	@RequestMapping(value = "/reservations/{reservationId}/edit", method = RequestMethod.GET)
	public String initUpdateReservationForm(@PathVariable("reservationId") int reservationId, Model model) {
		Reservation reservation = this.clinicService.findReservationById(reservationId);
		model.addAttribute(reservation);
		return "reservations/createOrUpdateReservationForm";
	}

	@RequestMapping(value = "/reservations/{reservationId}/edit", method = RequestMethod.PUT)
	public String processUpdateReservationForm(@Valid Reservation reservation, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "reservations/createOrUpdateReservationForm";
		} else {
			this.clinicService.saveReservation(reservation);
			status.setComplete();
			return "redirect:/reservations/{reservationId}";
		}
	}

	/**
	 * Custom handler for displaying an reservation.
	 *
	 * @param reservationId
	 *            the ID of the reservation to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/reservations/{reservationId}")
	public ModelAndView showReservation(@PathVariable("reservationId") int reservationId) {
		ModelAndView mav = new ModelAndView("reservations/reservationDetails");
		mav.addObject(this.clinicService.findReservationById(reservationId));
		return mav;
	}

	/**
	 * 客户端新预约接口
	 * 
	 * @param reservation
	 * @return reservation
	 */
	@RequestMapping(value = "/phone/new", method = RequestMethod.POST)
	public @ResponseBody Reservation createReservation(Reservation reservation, SessionStatus status) {
		if (StringUtils.hasLength(reservation.getIdCardNo()) && reservation.isNew()
				&& clinicService.findReservationByIdCardNo(reservation.getIdCardNo()) != null) {
			return null;
		}
		this.clinicService.saveReservation(reservation);
		status.setComplete();
		return reservation;

	}

	/**
	 * 客户端查询接口
	 * 
	 * @param reservation
	 * @return reservation
	 */
	@RequestMapping(value = "/phone/find", method = RequestMethod.POST)
	public @ResponseBody Reservation findReservation(Reservation reservation, SessionStatus status) {
		Collection<Reservation> results = this.clinicService
				.findReservationByIdCardNoAndPersonName(reservation.getIdCardNo(), reservation.getPersonName());
		if (results.isEmpty()) {
			// no reservations found
			return null;
		} else {
			// 1 reservation found
			reservation = results.iterator().next();
			return reservation;

		}

	}

}
