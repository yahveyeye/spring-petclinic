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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zymb.gxyhxx.reservation.model.Reservation;

/**
 * <p> Base class for {@link ClinicService} integration tests. </p> <p> Subclasses should specify Spring context
 * configuration using {@link ContextConfiguration @ContextConfiguration} annotation </p> <p>
 * AbstractclinicServiceTests and its subclasses benefit from the following services provided by the Spring
 * TestContext Framework: </p> <ul> <li><strong>Spring IoC container caching</strong> which spares us unnecessary set up
 * time between test execution.</li> <li><strong>Dependency Injection</strong> of test fixture instances, meaning that
 * we don't need to perform application context lookups. See the use of {@link Autowired @Autowired} on the <code>{@link
 * AbstractClinicServiceTests#clinicService clinicService}</code> instance variable, which uses autowiring <em>by
 * type</em>. <li><strong>Transaction management</strong>, meaning each test method is executed in its own transaction,
 * which is automatically rolled back by default. Thus, even if tests insert or otherwise change database state, there
 * is no need for a teardown or cleanup script. <li> An {@link org.springframework.context.ApplicationContext
 * ApplicationContext} is also inherited and can be used for explicit bean lookup if necessary. </li> </ul>
 *
 * @author Ken Krebs
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public abstract class AbstractClinicServiceTests {

    @Autowired
    protected ClinicService clinicService;

    @Test
    public void shouldFindReservationsByLastName() {
        Collection<Reservation> reservations = this.clinicService.findReservationByIdCardNo("Davis");
        assertThat(reservations.size()).isEqualTo(2);

        reservations = this.clinicService.findReservationByIdCardNo("Daviss");
        assertThat(reservations.isEmpty());
    }

    @Test
    @Transactional
    public void shouldInsertReservation() {
        Collection<Reservation> reservations = this.clinicService.findReservationByIdCardNo("Schultz");
        int found = reservations.size();
        
        Reservation reservation = new Reservation();
        reservation.setIdCardNo("54032119901111111X");
        reservation.setPersonName("Schultz");
        reservation.setPhone("12345678910");
        reservation.setEmail("123@qq.com");
        
        this.clinicService.saveReservation(reservation);
        assertThat(reservation.getId().longValue()).isNotEqualTo(0);

        reservations = this.clinicService.findReservationByIdCardNo("Schultz");
        assertThat(reservations.size()).isEqualTo(found + 1);
    }

    @Test
    @Transactional
    public void shouldUpdateReservation()  {
        Reservation reservation = this.clinicService.findReservationById(1);
        String oldLastName = reservation.getPersonName();
        String newLastName = oldLastName + "X";
        
        reservation.setPersonName(newLastName);
        this.clinicService.saveReservation(reservation);

        // retrieving new name from database
        reservation = this.clinicService.findReservationById(1);
        assertThat(reservation.getPersonName()).isEqualTo(newLastName);
    }





}
