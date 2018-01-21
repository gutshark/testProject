package cn.ch1jia2.study.interceptorTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class WorldController {

    @GetMapping
    public String hello() {
        return "Hello World.";
    }
}
