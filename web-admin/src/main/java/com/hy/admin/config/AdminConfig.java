package com.hy.admin.config;

import com.hy.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/13 10:18
 */
@Configuration
public class AdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //会拦截所有包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/image/**","/js/**","/sql","/druid/*");
    }
}
