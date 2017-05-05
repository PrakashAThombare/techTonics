package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UserPojo;

public class GetUser {

	public static UserPojo getUser(String email) throws SQLException
	{
		System.out.println("in getUser");
		Connection connection=CreateConnection.getConnection();
		java.sql.PreparedStatement statement =  connection.prepareStatement("select * from userdetails where emailId ='"+email+"'");
		System.out.println("after query");
		ResultSet set=statement.executeQuery();
		System.out.println(set);
		set.next();
		System.out.println("after execute query");
		UserPojo userPojo=new UserPojo();
		userPojo.setEmailId(set.getString(1));
		System.out.println("after set email");
		userPojo.setName(set.getString(2));
		System.out.println(userPojo);
		return userPojo; 


	}
}
