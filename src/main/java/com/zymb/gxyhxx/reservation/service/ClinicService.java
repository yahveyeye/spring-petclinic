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

import org.springframework.dao.DataAccessException;

import com.zymb.gxyhxx.reservation.model.Owner;
import com.zymb.gxyhxx.reservation.model.Pet;
import com.zymb.gxyhxx.reservation.model.PetType;
import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.model.Vet;
import com.zymb.gxyhxx.reservation.model.Visit;


/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface ClinicService {

    Collection<PetType> findPetTypes() throws DataAccessException;

    Owner findOwnerById(int id) throws DataAccessException;

    Pet findPetById(int id) throws DataAccessException;

    void savePet(Pet pet) throws DataAccessException;

    void saveVisit(Visit visit) throws DataAccessException;

    Collection<Vet> findVets() throws DataAccessException;

    void saveOwner(Owner owner) throws DataAccessException;

    Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;

	void saveReservation(Reservation reservation);

	Collection<Reservation> findReservationByLastName(String lastName);

	Reservation findReservationById(int reservationId);

}
