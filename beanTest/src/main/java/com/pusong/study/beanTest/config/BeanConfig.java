package com.pusong.study.beanTest.config;

import com.pusong.study.beanTest.bean.SmallWorld;
import com.pusong.study.beanTest.bean.World;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public World getWorld() {
        return new SmallWorld();
    }
}
