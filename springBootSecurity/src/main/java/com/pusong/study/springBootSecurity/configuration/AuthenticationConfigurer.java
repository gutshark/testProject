package com.pusong.study.springBootSecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.PostConstruct;

//@Configuration
public class AuthenticationConfigurer extends GlobalAuthenticationConfigurerAdapter {

    //@Autowired
    public AuthenticationManager authenticationManager;


    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("111111").roles("ADMIN")
                .and()
                .withUser("user01").password("123456").roles("USER")
                .and()
                .withUser("user02").password("password").roles("USER");
    }

    @PostConstruct
    public void post(){
        System.out.println("post");
    }
}
