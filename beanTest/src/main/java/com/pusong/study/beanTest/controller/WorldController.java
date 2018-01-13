package com.pusong.study.beanTest.controller;

import com.pusong.study.beanTest.bean.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class WorldController {
    @Autowired
    private World world;

    @GetMapping
    public String hello() {
        return this.world.hello();
    }
}
