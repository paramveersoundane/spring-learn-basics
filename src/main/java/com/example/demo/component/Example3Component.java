package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class Example3Component {

	@Autowired
	Example2Component example2Component;
	
	Long creationTime;
	
	public Example3Component(String info_1, String info_2) {
		this.creationTime = System.currentTimeMillis();
		System.out.println("Example3Component: Inside default constructor, creationTime & Hashcode:" + this.creationTime
				+ ", " + this.hashCode());
		
	}

	@PostConstruct
	public void postContructMethod() {
		System.out.println("In Example3Component @PostConstruct: After injection - Example2Component " + example2Component.toString());
	}

}
