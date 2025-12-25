package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.MyFilter1;

@Configuration
public class AppConfig_2 {

	@Bean
	public FilterRegistrationBean<MyFilter1> myfirstFilter(){
		
		FilterRegistrationBean<MyFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new MyFilter1());
		filterRegistrationBean.addUrlPatterns("/api/*");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
		
	}

}
