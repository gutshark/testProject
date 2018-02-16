package com.pusong.study.oauthInDBTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/worlds")
public class WorldController {
    @GetMapping
    public ResponseEntity<?> hello() {
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }
}
