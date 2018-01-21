package com.pusong.study.springBootSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String get() {
        return "Administrator";
    }
}
