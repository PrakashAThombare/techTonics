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

/**
 * Servlet implementation class addTechtalkServlet
 */
@WebServlet("/addTechtalkServlet")
public class addTechtalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTechtalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
    	String presentatinDate=request.getParameter("date");
    	String description=request.getParameter("description");
    	String presentor=request.getParameter("presentor");
    	
    	Connection connection= CreateConnection.getConnection();
    	System.out.println("before try");
    	try {
  		  ResultSet resultset = connection.createStatement().executeQuery("select * from techTalkdetails where title = '"+title+"'");
  		  System.out.println("in before check");
  		if(!resultset.next()){
  			System.out.println("in check result set");
  			PreparedStatement statement=(PreparedStatement) connection.prepareStatement("insert into techTalkdetails (presentationDate,title,description,presentor) values(?,?,?,?)");
  			System.out.println("in after check");
  			statement.setString(1, presentatinDate);
  			statement.setString(2, title);
  			statement.setString(3, description);
  			statement.setString(4, presentor);
  			int number=statement.executeUpdate();
  			if(number == 1)
  				request.setAttribute("message","SuccessFully Added TechTalk.");
  			response.sendRedirect("adminToHome.jsp");
  		}
  		
  			
  		
  	}
  	catch (SQLException e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  	}
	}

}
