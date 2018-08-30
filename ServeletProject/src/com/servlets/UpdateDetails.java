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
 * Servlet implementation class UpdateDetails
 */
@SuppressWarnings("serial")
public class UpdateDetails extends HttpServlet {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	/**
	 * Function to show the detail of the selected user
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("employeeid"));

		response.setContentType("text/html");
		out.println("<html><head> <title>Search Employee</title> <link rel='stylesheet' href='css/style.css' /> </head><body>");
		out.println("<div id='container'> <div id='navigator_table'>");
		out.println("<table><tr><td align='left'><img src='images/emp.png' width='10%' /></td><td align='right'><a href='index.html'>Home</a>  ");
		out.println("<a href='AddEmployee.html'>Add Employee</a> <a href='ShowEmployee'>Show Employee</a> <a href='SearchEmployee.html'>Search Employee</a></td></tr> <tr> <td colspan='2'><hr /></td> </tr> </table> </div> </div>");
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(Queries.selectQueryWithId);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			out.print("<form action='Update'>");
			out.println("<h1>Update Employee</h1>");

			// displaying the detail of the employee in the table
			while (resultSet.next()) {

				out.println("<div>");
				out.print("<span id='fname'>First name:</span>");
				out.print("<input type='text' id='first_name' name='first_name' value='" + resultSet.getString("first_name")
						+ "' placeholder='Enter First Name' required />");
				out.print("</div>");

				out.println("<div>");
				out.print("<span id='fname'>Last name:</span>");
				out.print("<input type='text' id='last_name' name='last_name' value='" + resultSet.getString("last_name")
						+ "' placeholder='Enter First Name' required />");
				out.print("</div>");

				out.println("<div>");
				out.print("<span id='fname' style='padding-right:30px'>Email:</span>");
				out.print("<input type='text' id='email' name='email' value='" + resultSet.getString("email")
						+ "' placeholder='Enter First Name' readonly />");
				out.print("</div>");

				out.println("<div>");
				out.print("<span id='fname' style='padding-right:40px'>Age:</span>");
				out.print("<input type='number' id='age' name='age' value='" + resultSet.getString("age")
						+ "' placeholder='Enter First Name' required />");
				out.print("</div>");

				out.println("<div>");
				out.print("<input type='submit' size='30px' value = 'Submit'/>");
				out.print("<input type='reset' size='30px' value = 'Reset'/>");
				out.print("</div>");

				out.println("<input type='hidden' id='employeeid' name='employeeid' value='" + id + "'/>");
				out.print("</form>");
			}

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
