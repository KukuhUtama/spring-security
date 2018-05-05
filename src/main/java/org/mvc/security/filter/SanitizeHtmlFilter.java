package org.mvc.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class SanitizeHtmlFilter implements Filter{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ArrayList<String> parameterValues;
	private Enumeration enumeration;
	private String paramName;
	private String paramValue;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		request = (HttpServletRequest) req;
		response = (HttpServletResponse) res;
		
	    parameterValues = new ArrayList<String>();
		enumeration = request.getParameterNames();
		
		while(enumeration.hasMoreElements()){
		     paramName = (String) enumeration.nextElement();
			 paramValue = (String) request.getParameter(paramName);
			 parameterValues.add(paramValue);
		}

		for(String value: parameterValues){
			  boolean valid = Jsoup.isValid(value, Whitelist.none());
			  if(!valid){
				  response.sendRedirect("login?logout=true");
				  return;
			  }
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
