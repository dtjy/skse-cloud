package com.skse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author jiangyao
 * @Date 2021/2/8 10:57
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 注册jwt拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(jwtInterceptor())
                .excludePathPatterns("/login/login") //排除登录
                .addPathPatterns("/**");
    }

    /**
     * jwt拦截器
     * @return
     */

    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
