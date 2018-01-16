package cn.ch1jia2.study.profilesActiveTest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @Value("${hello.message}")
    private String message;

    @GetMapping
    public String hello() {
        return "Hello " + message;
    }
}