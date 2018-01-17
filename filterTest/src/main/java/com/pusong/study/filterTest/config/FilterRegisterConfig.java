package com.pusong.study.filterTest.config;

import com.pusong.study.filterTest.filter.PermisionFilter;
import com.pusong.study.filterTest.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegisterConfig {

    @Bean
    public FilterRegistrationBean getPermisionFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(getPermisionFilter());
        filterRegistrationBean.addUrlPatterns("/worlds/*");
        filterRegistrationBean.setOrder(Integer.MAX_VALUE);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getSessionFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(getSessionFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(Integer.MAX_VALUE - 1);

        return filterRegistrationBean;
    }

    @Bean
    public PermisionFilter getPermisionFilter() {
        return new PermisionFilter();
    }

    @Bean
    public SessionFilter getSessionFilter() {
        return new SessionFilter();
    }
}
