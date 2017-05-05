package util;

import java.sql.*;



public class CreateConnection {

	private static Connection connection=null;
	public static Connection getConnection()
	{
		try{  
			if(connection == null)
			{
				Class.forName("com.mysql.jdbc.Driver");  
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_DB?useSSL=true","root","root");
				//here sonoo is database name, root is username and password

			}
		}
		catch(Exception e){ System.out.println(e);}  
		return connection;
	}  
}

