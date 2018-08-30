package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionManager;
import com.employee.Queries;

/**
 * Servlet implementation class ShowEmployee
 */

@SuppressWarnings("serial")
public class ShowEmployee extends HttpServlet {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	/**
	 * Function to display employee detail on the page
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head> <title>Search Employee</title> <link rel='stylesheet' href='css/style.css' /> </head><body align='-webkit-center'>");
		out.println("<div id='container'> <div id='navigator_table'>");
		out.println("<table><tr><td align='left'><img src='images/emp.png' width='10%' /></td><td align='right'><a href='index.html'>Home</a>  ");
		out.println("<a href='AddEmployee.html'>Add Employee</a> <a href='ShowEmployee'>Show Employee</a> <a href='SearchEmployee.html'>Search Employee</a></td></tr> <tr> <td colspan='2'><hr /></td> </tr> </table> </div> </div>");
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(Queries.selectQuery);
			resultSet = statement.executeQuery();
			out.println("<h1>Employee Details</h1>");

			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th><th>AGE</th><th>Update</th><tr>");

			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				int id = resultSet.getInt("id");

				out.println("<tr><td>" + firstName + "</td><td>" + lastName + "</td><td>" + email + "</td><td>" + age + "</td>");

				// creating the form
				out.println("<td><form action='UpdateDetails'>");
				out.println("<input type='hidden' id='employeeid' name='employeeid' value='" + id + "'/>");
				out.println("<input type='submit' value='Update'/>");
				out.print("</form></td></tr>");
			}

			out.println("</table>");
			out.println("</body></html>");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close ResultSet
				if (resultSet != null) {
					resultSet.close();
				}
				// Close Prepared Statement Object
				if (statement != null) {
					statement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}
}
