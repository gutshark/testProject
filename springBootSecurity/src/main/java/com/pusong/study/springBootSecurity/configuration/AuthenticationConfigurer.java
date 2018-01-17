package com.pusong.study.springBootSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthenticationConfigurer extends GlobalAuthenticationConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder())
                .withUser("admin").password("111111").roles("ADMIN")
                .and()
                .withUser("user01").password("123456").roles("USER")
                .and()
                .withUser("user02").password("password").roles("USER");
    }
}
