package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.component.Example2Component;
import com.example.demo.component.Example3Component;
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
	
	@Bean
	public Example2Component createExample2Component() {
		System.out.println("In Configuration creating Bean: Example2Component");
		return new Example2Component("Information-1");
	}
	@Bean
	public Example2Component createExample2Component1() {
		System.out.println("In Configuration creating Bean: Example2Component 1");
		return new Example2Component("Information-1");
	}
	@Bean
	public Example3Component createExample3Component() {
		System.out.println("In Configuration creating Bean: Example3Component");
		return new Example3Component("Information-1", "Information-2");
	}

}
