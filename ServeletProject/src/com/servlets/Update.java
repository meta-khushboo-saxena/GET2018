package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionManager;
import com.employee.Queries;

/**
 * Servlet implementation class Update
 */

@SuppressWarnings("serial")
public class Update extends HttpServlet {
	private Connection connection = null;
	private PreparedStatement statement;

	/**
	 * Function to update the detail of the employee
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int dataCount = 0;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(Queries.updateQuery);
			statement.setString(1, request.getParameter("first_name"));
			statement.setString(2, request.getParameter("last_name"));
			statement.setString(3, request.getParameter("email"));
			statement.setInt(4, Integer.parseInt(request.getParameter("age")));
			statement.setInt(5, Integer.parseInt(request.getParameter("employeeid")));
			dataCount = statement.executeUpdate();

			if (dataCount > 0) {
				out.print("<h1 align='center'>Data Updated</h1>");
				out.println("<a href='index.html'>Home Page</a>");
			}
		} catch (SQLException ex) {
			System.out.println("error");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close Prepared Statement Object
				if (statement != null) {
					statement.close();
				}
				// Close the connection
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
