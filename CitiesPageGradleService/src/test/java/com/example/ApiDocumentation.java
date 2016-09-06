package com.example;

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

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by kostya.nikitin on 9/5/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDocumentation {

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
    public void indexExample() throws Exception {

        given(this.citiesUIService.getCities()
        ).willReturn(Arrays.asList(new  Cities(1, "city1"), new  Cities(2, "city2")));

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
        ;
    }

}
