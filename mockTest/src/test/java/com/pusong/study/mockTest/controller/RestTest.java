package com.pusong.study.mockTest.controller;

import com.pusong.study.mockTest.model.HelloResponseModel;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() {
        ResponseEntity<HelloResponseModel> response = restTemplate.getForEntity(
                "/worlds?name={name}",
                HelloResponseModel.class,
                "World");

        TestCase.assertEquals(response.getStatusCode(), HttpStatus.OK);
        TestCase.assertEquals(response.getBody().getMessage(), "Hello World");
    }
}