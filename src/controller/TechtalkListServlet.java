package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import util.CreateConnection;

/**
 * Servlet implementation class TechtalkListServlet
 */
@WebServlet("/TechtalkListServlet")
public class TechtalkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TechtalkListServlet() {
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
		try {
		System.out.println("at begining");
		HttpSession session=request.getSession(true);
		System.out.println("after session");
		String name=(String) session.getAttribute("email");
		System.out.println("after emial");
		int techTalkId=(int) session.getAttribute("id");
		System.out.println(name+"  "+techTalkId);
	    Connection connection=CreateConnection.getConnection();
	    PreparedStatement statement=(PreparedStatement) connection.prepareStatement("insert into RegisteredUser values(?,?)");
		System.out.println("in after check");
		statement.setInt(1, techTalkId);
			statement.setString(2, name);
			int number=statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
