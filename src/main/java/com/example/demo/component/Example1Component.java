package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class Example1Component {
	Long creationTime;
	
	public Example1Component() {
		this.creationTime = System.currentTimeMillis();
		System.out.println("Example1Component: Inside default constructor, creationTime & Hashcode:"+ this.creationTime+", "+this.hashCode() );
		
	}

	@Override
	public String toString() {
		return this.hashCode() + ", Example1Component [creationTime=" + creationTime + "]";
	}
	

}
