package example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewStudent
 */

public class viewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final String url = "jdbc:mysql://localhost:3306/student_registration";
	    private static final String USER = "root";
	    private static final String PASSWORD = "9965";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<data>datas=new ArrayList<>();
		  Connection c;
		try {
			c = DriverManager.getConnection(url, USER, PASSWORD);
	
          String selectQuery = "SELECT * FROM student";
          PreparedStatement s = c.prepareStatement(selectQuery);
          ResultSet r = s.executeQuery();
		
          
         while(r.next()) {
        	 int id = r.getInt("id");
        	 String name = r.getString("name");
        	 String email = r.getString("email");
        	 int age = r.getInt("age");
        	 
        	 data d = new data(id,name,email,age);
        	 datas.add(d);
         }
         c.close();
          s.close();
          r.close();
         
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("datas",datas);
		request.getRequestDispatcher("studentlist.jsp").forward(request, response);
		
	}

}
