package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.demo.interceptor.MyCustomInterceptor;

@Configuration
public class AppConfig_1 implements WebMvcConfigurer {

	@Autowired
	MyCustomInterceptor interceptorObj;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptorObj).addPathPatterns("/api/*")
		.excludePathPatterns("api/fetchLib");
	}

}
