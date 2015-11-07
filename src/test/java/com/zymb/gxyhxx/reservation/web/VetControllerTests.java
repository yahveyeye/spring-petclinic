package com.zymb.gxyhxx.reservation.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zymb.gxyhxx.reservation.config.BusinessConfig;
import com.zymb.gxyhxx.reservation.config.MvcCoreConfig;
import com.zymb.gxyhxx.reservation.config.ToolsConfig;
import com.zymb.gxyhxx.reservation.web.VetController;

/**
 * Test class for the UserResource REST controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = { BusinessConfig.class, ToolsConfig.class }),
        @ContextConfiguration(classes = MvcCoreConfig.class)})
@ActiveProfiles("spring-data-jpa")
public class VetControllerTests {

    @Autowired
    private VetController vetController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(vetController).build();
    }

    @Test
    public void testGetExistingUser() throws Exception {
    	ResultActions actions = mockMvc.perform(get("/vets.json").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    	actions.andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.vetList[0].id").value(1));
    }
}
