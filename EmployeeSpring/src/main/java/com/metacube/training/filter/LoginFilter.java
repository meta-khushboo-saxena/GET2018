package com.metacube.training.filter;

import java.io.PrintWriter;

import javax.servlet.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.enums.Status;
import com.metacube.training.facade.UserFacade;
import com.metacube.training.model.UserDetail;

public class LoginFilter implements javax.servlet.Filter {

	
	private FilterConfig filterConfig;

	@Autowired
	private UserFacade userFacade ;
	private UserDetail userDetail = new UserDetail();

	public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain)
			throws java.io.IOException, javax.servlet.ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (request.getParameter("email") != "" && request.getParameter("password") != "") {
			userDetail.setEmail(request.getParameter("email"));
			userDetail.setPassword(request.getParameter("password"));

			Status status = userFacade.checkUserDetail(userDetail);

			if (Status.DUPLICATE.equals(status)) {
				chain.doFilter(request, response);

			} else {
				out.println("!!User not Registered!!");
			}
		} else {
			RequestDispatcher requestdispatch = request.getRequestDispatcher("/login.html");
			requestdispatch.include(request, response);
			out.println("<script>alert('!!Please enter your email and password!!')</script>");
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
