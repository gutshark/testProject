package com.pusong.study.oauthInDBTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/worlds")
public class WorldController {
    @GetMapping
    public ResponseEntity<?> hello() {

        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<String>("I'm a World!", HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentAccount(Principal principal) {
        System.out.println("user: " + principal.getName());

        return new ResponseEntity<>(SecurityContextHolder.getContext().getAuthentication(), HttpStatus.OK);
//        return principal;
    }

    //    @PermitAll
    @GetMapping("/public")
    public ResponseEntity<?> getPublic() {

        return new ResponseEntity<>(
                "this is a public message\nauthentication: " + SecurityContextHolder.getContext().getAuthentication(),
                HttpStatus.OK);
    }
}
