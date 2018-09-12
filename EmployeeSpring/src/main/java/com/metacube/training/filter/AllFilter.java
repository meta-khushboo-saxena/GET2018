package com.metacube.training.filter;

import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AllFilter implements javax.servlet.Filter {

	public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain)
			throws java.io.IOException, javax.servlet.ServletException {

		PrintWriter out = response.getWriter();
		
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		if(session == null){
			RequestDispatcher requestdispatch = request.getRequestDispatcher("/login.html");
			requestdispatch.include(request, response);
			out.println("<script>alert('!!Please Login First')</script>");
		}else{
			chain.doFilter(request, response);
		}		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
