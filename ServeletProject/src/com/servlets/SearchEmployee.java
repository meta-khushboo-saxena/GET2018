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
 * Servlet implementation class SearchEmployeee
 */
@SuppressWarnings("serial")
public class SearchEmployee extends HttpServlet {
	private Connection connection = null;
	private PreparedStatement statement;
	private ResultSet resultSet = null;

	/**
	 * Function to search and display employee detail by first name and lastname
	 * @param request
	 * @param response 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String firstNameToSearch = request.getParameter("first_name");
		String lastNameToSearch = request.getParameter("last_name");

		response.setContentType("text/html");
		out.println("<html><head> <title>Search Employee</title> <link rel='stylesheet' href='css/style.css' /> </head><body>");
		out.println("<div id='container'> <div id='navigator_table'>");
		out.println("<table><tr><td align='left'><img src='images/emp.png' width='10%' /></td><td align='right'><a href='index.html'>Home</a>  ");
		out.println("<a href='AddEmployee.html'>Add Employee</a> <a href='ShowEmployee'>Show Employee</a> <a href='SearchEmployee.html'>Search Employee</a></td></tr> <tr> <td colspan='2'><hr /></td> </tr> </table> </div> </div>");

		// searching employee by first name and last name
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(Queries.searchQuery);
			statement.setString(1, firstNameToSearch);
			statement.setString(2, lastNameToSearch);

			resultSet = statement.executeQuery();

			// checking if there is data or not
			if (resultSet.next()) {
				out.println("<table border=1 width=50%>");
				out.println("<tr><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th><th>AGE</th><tr>");
				do {
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					String email = resultSet.getString("email");
					int age = resultSet.getInt("age");
					out.println("<tr><td>" + firstName + "</td><td>" + lastName + "</td><td>" + email + "</td><td>" + age
							+ "</td></tr>");
				} while (resultSet.next());
			} else {
				out.println("<div align=" + "center" + "><h1>No Data Exist!!<h1>");
			}
			out.println("</table>");
			out.println("</html></body>");

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
