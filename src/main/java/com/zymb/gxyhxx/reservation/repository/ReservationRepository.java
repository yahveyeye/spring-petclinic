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
package com.zymb.gxyhxx.reservation.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.zymb.gxyhxx.reservation.model.BaseEntity;
import com.zymb.gxyhxx.reservation.model.Reservation;

/**
 * Repository class for <code>Reservation</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public interface ReservationRepository {

	
	/**
     * Retrieve <code>Reservation</code>s from the data store by last name, returning all reservations whose last name <i>starts</i>
     * with the given name.
     *
     * @param idCardNo Value to search for
     * @param personName Value to search for
     * @return a <code>Collection</code> of matching <code>Reservation</code>s (or an empty <code>Collection</code> if none
     *         found)
     */
    Collection<Reservation> findByIdCardNoAndPersonName(String idCardNo,String personName) throws DataAccessException;
	
	
    /**
     * Retrieve <code>Reservation</code>s from the data store by last name, returning all reservations whose last name <i>starts</i>
     * with the given name.
     *
     * @param idCardNo Value to search for
     * @return a <code>Collection</code> of matching <code>Reservation</code>s (or an empty <code>Collection</code> if none
     *         found)
     */
    Collection<Reservation> findByIdCardNo(String idCardNo) throws DataAccessException;

    /**
     * Retrieve an <code>Reservation</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Reservation</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException
     *          if not found
     */
    Reservation findById(int id) throws DataAccessException;


    
    
    /**
     * Save an <code>Reservation</code> to the data store, either inserting or updating it.
     *
     * @param reservation the <code>Reservation</code> to save
     * @see BaseEntity#isNew
     */
    void save(Reservation reservation) throws DataAccessException;


}
