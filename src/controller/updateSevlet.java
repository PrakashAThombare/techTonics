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

import model.Techtalkpojo;
import util.CreateConnection;


@WebServlet("/updateSevlet")
public class updateSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Connection connection=CreateConnection.getConnection();
		 try {
			PreparedStatement statement=(PreparedStatement) connection.prepareStatement("select * from techtalkdetails where techId="+id);
			ResultSet set=statement.executeQuery();
			Techtalkpojo techpojo=null;
			while(set.next())
			{
				techpojo=new Techtalkpojo();
				techpojo.setTechId(set.getInt(1));
				techpojo.setPresentationdate(set.getDate(2));
				techpojo.setTitle(set.getString(3));
				techpojo.setDescription(set.getString(4));
				techpojo.setPresentor(set.getString(5));
				
			}
			request.setAttribute("tech", techpojo);
			request.getRequestDispatcher("updateTechtalk.jsp").forward(request,response);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
