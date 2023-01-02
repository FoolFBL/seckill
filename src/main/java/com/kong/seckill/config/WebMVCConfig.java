package com.kong.seckill.config;

import com.kong.seckill.controller.interceptor.loginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private loginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截一切请求
        registry.addInterceptor(loginInterceptor)
                //过滤的静态资源
                .excludePathPatterns("/**/*.css","/**/*.js","/**/*.png","/**/*.jpg","/**/*.png")
                //拦截的
                .addPathPatterns("/goods/**")
                .addPathPatterns("/secKill/**");
    }
}