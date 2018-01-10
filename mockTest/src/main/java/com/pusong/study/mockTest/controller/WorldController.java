package com.pusong.study.mockTest.controller;

import com.pusong.study.mockTest.model.HelloResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class WorldController {
    @GetMapping
    public ResponseEntity<HelloResponseModel> hello(@RequestParam(value = "name", required = true) String name) {
        HelloResponseModel model = new HelloResponseModel();
        model.setMessage("Hello " + name);

        return new ResponseEntity<HelloResponseModel>(model, HttpStatus.OK);
    }
}