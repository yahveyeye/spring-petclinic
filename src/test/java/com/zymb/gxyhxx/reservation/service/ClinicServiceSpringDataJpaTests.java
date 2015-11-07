
package com.zymb.gxyhxx.reservation.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zymb.gxyhxx.reservation.config.BusinessConfig;

/**
 * <p> Integration test using the 'Spring Data' profile. 
 * @see AbstractClinicServiceTests AbstractClinicServiceTests for more details. </p>
 * @author Michael Isvy
 */

@ContextConfiguration(classes = BusinessConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("spring-data-jpa")
public class ClinicServiceSpringDataJpaTests extends AbstractClinicServiceTests {

}