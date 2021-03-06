package org.mvc.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.mvc.security.entity.XSSRequestWrapper;

public class XssFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	    chain.doFilter(new XSSRequestWrapper((HttpServletRequest) req), res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}


}
