package com.example.demo.controller;


import org.springframework.stereotype.Component;
import com.example.demo.entity.Book;
@Component
public class BookController {
	Long  creationTime;
	String title;
	public BookController(String title) {
		this.creationTime =System.currentTimeMillis() ;
		this.title = title;
		System.out.println("Creation time: "+ this.creationTime + ", BookController object creation from the paramterized contructor! " + this.hashCode());
		
	}

	public BookController() {
		
		this.creationTime =System.currentTimeMillis() ;
		System.out.println("Creation time: "+ this.creationTime + ", BookController object creation from the default contructor! " + this.hashCode());
	}

	
}
