package com.app.neurorehab.controller.config;

import com.app.neurorehab.controller.security.filters.RequestInterceptorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RequestInterceptorFilter requestInterceptorFilter;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8089")
                .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
                .maxAge(4800);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptorFilter);
    }
}