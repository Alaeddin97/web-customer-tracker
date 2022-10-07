package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String user = "springstudent";
		String pass = "springstudent";
		String driver = "com.mysql.cj.jdbc.Driver";
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Connection successful !!!");
			myConnection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
