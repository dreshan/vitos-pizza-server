package com.example.vitospizzaserver.component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

@Controller
public class SimpleCORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httPresponse = (HttpServletResponse) response;

	    httPresponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
	    httPresponse.setHeader("Access-Control-Allow-Credentials", "true");
	    httPresponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    httPresponse.setHeader("Access-Control-Max-Age", "3600");
	    httPresponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

	    chain.doFilter(httpRequest, httPresponse);
		
	}

}
