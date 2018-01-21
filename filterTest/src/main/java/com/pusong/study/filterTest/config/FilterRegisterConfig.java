package com.pusong.study.filterTest.config;

import com.pusong.study.filterTest.filter.PermissionFilter;
import com.pusong.study.filterTest.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegisterConfig {

    @Bean
    public FilterRegistrationBean getPermissionFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(getPermissionFilter());
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
    public PermissionFilter getPermissionFilter() {
        return new PermissionFilter();
    }

    @Bean
    public SessionFilter getSessionFilter() {
        return new SessionFilter();
    }
}
