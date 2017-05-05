package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserPojo;
import util.GetUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserPojo user=null;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+password);
		if(email=="" || password == "")
		{
			request.setAttribute("info","Email Or Password is Not Entered ...");
			System.out.println(email+password);
			response.sendRedirect("login.jsp");

		}

		else{

			if(Validation.isUSerExist(email, password))
			{
				HttpSession session=request.getSession();
				try {
					user=GetUser.getUser(email);
					System.out.println(user);
					session.setAttribute("name",user.getName());
					if(email.equals("rohan@atmecs.com") && password.equals("123456") )
						response.sendRedirect("adminToHome.jsp");
					else
					{
						
						session.setAttribute("email",email);
						/*  System.out.println(email);*/
						response.sendRedirect("userToHome.jsp");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			else
				request.setAttribute("msg","User Not Exist.. Please Register First.");
			//response.sendRedirect("login.jsp");
		}
	}

}
