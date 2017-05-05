package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import util.CreateConnection;

public class Validation {

	public static boolean  isUSerExist(String email,String password)
	{
		Connection connection=CreateConnection.getConnection();
		try {
			System.out.println("in is userexixst");
			ResultSet set=connection.createStatement().executeQuery("select * from userdetails where emailId='"+email+"' and password='"+password+"'");
			 
			if(set!= null)
			 return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
	

}

