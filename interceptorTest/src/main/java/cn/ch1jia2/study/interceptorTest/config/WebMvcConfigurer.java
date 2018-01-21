package cn.ch1jia2.study.interceptorTest.config;

import cn.ch1jia2.study.interceptorTest.interceptor.LoggerInterceptor;
import cn.ch1jia2.study.interceptorTest.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new LoggerInterceptor());
        registry.addInterceptor(new SecurityInterceptor());

    }
}
