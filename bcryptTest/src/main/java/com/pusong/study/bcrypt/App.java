package com.pusong.study.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class App {
    public static void main(String[] args) {
//        String pass = "123456";
//        String pass = "secret";
        String pass = "admin";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            String hashPass = bCryptPasswordEncoder.encode(pass);
            System.out.println(hashPass);
        }
//        String hashPass = bCryptPasswordEncoder.encode(pass);
//        bCryptPasswordEncoder.encode()
//        System.out.println(hashPass);
    }
}
