package com.pusong.study.h2Test.controller;

import com.pusong.study.h2Test.business.UserBusiness;
import com.pusong.study.h2Test.business.dto.UserRequestDTO;
import com.pusong.study.h2Test.business.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserBusiness userBusiness;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") int id) {
        return new ResponseEntity<UserResponseDTO>(
                userBusiness.get(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserRequestDTO request) {
        return new ResponseEntity<UserResponseDTO>(
                userBusiness.add(request),
                HttpStatus.OK);
    }
}
