package com.pusong.study.aopTest.controller;

import com.pusong.study.aopTest.annotation.LogAnnotation;
import com.pusong.study.aopTest.model.WorldRequestModel;
import com.pusong.study.aopTest.model.WorldResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("worlds")
public class WorldController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @LogAnnotation(code = "get world", description = "get method")
    @GetMapping()
    public ResponseEntity<String> get(@RequestParam("name") String name) throws Exception {
        if ("error".equals(name)) {
            throw new Exception("name is ERROR");
        }
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @LogAnnotation(code = "add world")
    @PostMapping
    public ResponseEntity<WorldResponseModel> add(@RequestBody WorldRequestModel request, @RequestParam(value = "name", required = false) String name) {
        WorldResponseModel response = new WorldResponseModel();
        response.setName(request.getName());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
