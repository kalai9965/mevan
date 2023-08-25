package example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String url= "jdbc:mysql://localhost:3306/student_registration";
	    private static final String USER = "root";
	    private static final String PASSWORD = "9965";
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		    
		        String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        int age = Integer.parseInt(request.getParameter("age"));

		        try {
		            Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
		            String insertQuery = "INSERT INTO student (name, email, age) VALUES (?, ?, ?)";
		            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		            preparedStatement.setString(1, name);
		            preparedStatement.setString(2, email);
		            preparedStatement.setInt(3, age);
		            preparedStatement.executeUpdate();

		            preparedStatement.close();
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        response.sendRedirect("index.html");
		    }
		
		
	}


