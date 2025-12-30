package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.BookController;

@Configuration
public class BeanConfigExample {

	@Bean
	public BookController createBeanWithDefaultConstr() {
		System.out.println("I am in the bean for BookController");
		return new BookController();
	}
	
	@Bean
	public BookController createBeanWithParamContr() {
		System.out.println("I am in the bean for BookController");
		return new BookController("Homo-Deus");
	}

}
