package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Example2Component {
	@Autowired
	Example1Component example1Component;

	Long creationTime;

	public Example2Component() {
		this.creationTime = System.currentTimeMillis();
		System.out.println("Example2Component: Inside default constructor, creationTime & Hashcode:" + this.creationTime
				+ ", " + this.hashCode());
		// System.out.println("Example2Component: Inside default
		// constructor-Example1Component " + example1Component.hashCode()); -->// this
		// steps throw error
	}

	@PostConstruct
	public void postContructMethod() {
		System.out.println("In Example2Component @PostConstruct: After injection - Example1Component " + example1Component.toString());
	}

}
