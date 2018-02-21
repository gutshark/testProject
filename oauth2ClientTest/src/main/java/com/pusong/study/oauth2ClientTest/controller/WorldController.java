package com.pusong.study.oauth2ClientTest.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("worlds")
public class WorldController {
    @GetMapping
    public ResponseEntity<?> hello() {
        return new ResponseEntity<>("Hello World.", HttpStatus.OK);
    }
}
