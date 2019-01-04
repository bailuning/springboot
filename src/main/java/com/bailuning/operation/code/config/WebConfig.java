package com.bailuning.operation.code.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


//@Configuration
public class WebConfig implements WebMvcConfigurer {

    Logger logger = LoggerFactory.getLogger(WebConfig.class);

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login").setViewName("/**");
    }

    /**
     * 拦截器 AOP
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/**");
    }

    /**
     * 过滤器
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean filterRegistry() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new MyFilter());
        frBean.addUrlPatterns("/*");
        logger.info("filter: 过滤器执行");
        return frBean;
    }

    /**
     * 监听器
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new MyHttpSessionListener());
        logger.info("listener: 监听器执行");
        return srb;
    }
}