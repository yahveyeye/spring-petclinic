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
package com.zymb.gxyhxx.reservation.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.repository.ReservationRepository;

/**
 * Mostly used as a facade for all reservation controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

	private ReservationRepository reservationRepository;

	@Autowired
	public ClinicServiceImpl(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	@Override
	@Transactional
	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	@Transactional(readOnly = true)
	public Reservation findReservationByIdCardNo(String idCardNo) {
		return reservationRepository.findByIdCardNo(idCardNo);
	}

	@Override
	@Transactional(readOnly = true)
	public Reservation findReservationById(int reservationId) {
		return reservationRepository.findById(reservationId);
	}

	@Override
	public Collection<Reservation> findReservationByIdCardNoAndPersonName(String idCardNo, String personName) {
		return reservationRepository.findByIdCardNoAndPersonName(idCardNo,personName);
	}

}
