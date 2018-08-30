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
import com.employee.EmployeeDetail;
import com.employee.Queries;

/**
 * Servlet implementation class AddEmployee
 */

@SuppressWarnings("serial")
public class AddEmployee extends HttpServlet {

	private Connection connection = null;
	private PreparedStatement statement;
	private EmployeeDetail employeeDetail;
	private ResultSet resultSet = null;

	/**
	 * Function to check if the email exists or not
	 * 
	 * @param email
	 *            : email id of the user
	 * @return boolean
	 */
	public boolean checkEmail(String email) {
		try {
			statement = connection.prepareStatement(Queries.selectQueryByEmail);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			resultSet.last();
			int rows = resultSet.getRow();
			resultSet.beforeFirst();
			if (rows == 0) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("error");
		}
		return false;
	}

	/**
	 * Function to add employee detail in the table
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int result = 0;

		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		employeeDetail = new EmployeeDetail(firstName, lastName, email, age);

		// adding the details in the database
		try {
			connection = ConnectionManager.getConnection();
			if (checkEmail(email)) {
				statement = connection.prepareStatement(Queries.insertQuery);
				statement.setString(1, employeeDetail.getFirstName());
				statement.setString(2, employeeDetail.getLastName());
				statement.setString(3, employeeDetail.getEmail());
				statement.setInt(4, age);

				result = statement.executeUpdate();

				// checking if the data is inserted or not
				if (result > 0) {
					out.println("<h1 align='center'>Employee Successfully Added !!</h1>");
					out.println("<a href='index.html'>Home Page</a>");
				} else {
					out.println("!! ERROR !!");
				}
			} else {
				out.print("<h1 align='center'>Email already Exists!!</h1>");
				out.println("<a href='index.html'>Home Page</a>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
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
