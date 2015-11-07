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
package com.zymb.gxyhxx.reservation.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
import org.springframework.stereotype.Repository;

import com.zymb.gxyhxx.reservation.model.Reservation;
import com.zymb.gxyhxx.reservation.repository.ReservationRepository;
import com.zymb.gxyhxx.reservation.repository.ReservationRepository;

/**
 * JPA implementation of the {@link ReservationRepository} interface.
 *
 * @author Mike Keith
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaReservationRepositoryImpl implements ReservationRepository {

    @PersistenceContext
    private EntityManager em;


    /**
     * Important: in the current version of this method, we load Reservations with all their Pets and Visits while 
     * we do not need Visits at all and we only need one property from the Pet objects (the 'name' property).
     * There are some ways to improve it such as:
     * - creating a Ligtweight class (example here: https://community.jboss.org/wiki/LightweightClass)
     * - Turning on lazy-loading and using {@link OpenSessionInViewFilter}
     */
    @SuppressWarnings("unchecked")
    public Collection<Reservation> findByLastName(String lastName) {
        // using 'join fetch' because a single query should load both reservations and pets
        // using 'left join fetch' because it might happen that an reservation does not have pets yet
        Query query = this.em.createQuery("SELECT DISTINCT reservation FROM Reservation reservation  WHERE reservation.lastName LIKE :lastName");
        query.setParameter("lastName", lastName + "%");
        return query.getResultList();
    }

    @Override
    public Reservation findById(int id) {
        // using 'join fetch' because a single query should load both reservations and pets
        // using 'left join fetch' because it might happen that an reservation does not have pets yet
        Query query = this.em.createQuery("SELECT reservation FROM Reservation reservation  WHERE reservation.id =:id");
        query.setParameter("id", id);
        return (Reservation) query.getSingleResult();
    }


    @Override
    public void save(Reservation reservation) {
    	if (reservation.getId() == null) {
    		this.em.persist(reservation);     		
    	}
    	else {
    		this.em.merge(reservation);    
    	}

    }

}
