package com.example.demo.component;

import com.example.demo.controller.BookController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "sqlconnection", value = "enabled", havingValue = "true", matchIfMissing = true)

public class MySQLConnectionExample {

   
	public MySQLConnectionExample() {
		System.out.println("MySQLConnectionExample: @ConditionalOnProperty returns true, Bean created!");
	}

}
