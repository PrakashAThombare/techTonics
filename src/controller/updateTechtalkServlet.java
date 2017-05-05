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
 * Servlet implementation class updateTechtalkServlet
 */
@WebServlet("/updateTechtalkServlet")
public class updateTechtalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateTechtalkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String presentatinDate=request.getParameter("date");
		String description=request.getParameter("description");
		String presentor=request.getParameter("presentor");
      
		Connection connection= CreateConnection.getConnection();
		System.out.println("before try");
		PreparedStatement statement;
		try {
			statement = (PreparedStatement) connection.prepareStatement("update techTalkdetails set presentationDate=?,title=?,description=?,presentor=? where techId =?");
			
			System.out.println("in after check");
			statement.setString(1, presentatinDate);
			statement.setString(2, title);
			statement.setString(3, description);
			statement.setString(4, presentor);
			statement.setInt(5,id);
			int number=statement.executeUpdate();
			response.sendRedirect("adminToHome.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
