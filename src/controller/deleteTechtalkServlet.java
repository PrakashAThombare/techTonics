package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import util.CreateConnection;


/**
 * Servlet implementation class deleteTechtalkServlet
 */
@WebServlet("/deleteTechtalkServlet")
public class deleteTechtalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside delete");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Connection connection=CreateConnection.getConnection();
		try {
			PreparedStatement statement=(PreparedStatement) connection.prepareStatement("delete from techTalkdetails where techId="+id);
			statement.executeUpdate();
			response.sendRedirect("adminToHome.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
