package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import util.CreateConnection;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name=request.getParameter("fname");
    	String email=request.getParameter("email");
    	String password=request.getParameter("password");
    	System.out.println(name + email + password);
    	Connection connection= CreateConnection.getConnection();
    	System.out.println("before try");

    	try {
    		  ResultSet resultset = connection.createStatement().executeQuery("select * from userdetails where emailId = '"+email+"'");
    		  System.out.println("in before check");
    		if(!resultset.next()){
    			System.out.println("in check result set");
    			PreparedStatement statement=(PreparedStatement) connection.prepareStatement("insert into userdetails values(?,?,?)");
    			System.out.println("in after check");
    			statement.setString(1, email);
    			statement.setString(2, name);
    			statement.setString(3, password);
    			int number=statement.executeUpdate();
    			if(number == 1)
    				request.setAttribute("message","SuccessFully Registered.");

    		}
    		else{
    			request.setAttribute("Message","Email Id already Exist...");
    		}
    			response.sendRedirect("login.jsp");
    		
    	}
    	catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}

	   
	}

}
