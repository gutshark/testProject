package com.pusong.study.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/worlds")
public class WorldController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "worlds/hello";
    }
}
