package com.example.demo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter1 implements Filter {
	
	@Override
	 public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter1: init method.");
		Filter.super.init(filterConfig);
    }
	
	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
            throws IOException, ServletException{
		System.out.println("MyFilter1: inside doFilter logic. ");
		
		System.out.println("Print parameter: "+ servletrequest.getParameter("location"));
		filterchain.doFilter(servletrequest, servletresponse);
		System.out.println("work on request: "+ servletresponse);
		System.out.println("MyFilter1 completed ");
	}

}
