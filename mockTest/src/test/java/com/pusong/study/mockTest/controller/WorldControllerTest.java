package com.pusong.study.mockTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pusong.study.mockTest.model.HelloResponseModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        String response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/worlds")
                        .param("name", "World"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

//        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        HelloResponseModel model = mapper.readValue(response, HelloResponseModel.class);

        assertTrue(model.getMessage().equals("Hello World."));
    }
}
