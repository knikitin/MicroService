package com.example.web;

import com.example.dto.Cities;
import com.example.service.CitiesUIService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.ConnectException;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kostya.nikitin on 9/9/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CitiesUIControllerAdviceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .alwaysDo(print())
                .build();
    }

    @MockBean
    private CitiesUIService citiesUIService;

    @Test
    public void IllegalStateExceptionExceptionHandler_ServiceWithDataFromDBNotRegisteredInEureka_ReturnResponseWithInternalServerError() throws Exception {
        given(this.citiesUIService.getCities()
        ).willThrow(new IllegalStateException("Not found service to get data form DB"));

        this.mockMvc.perform(get("/"))

                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Not found service to get data form DB"))
        ;
    }

}
