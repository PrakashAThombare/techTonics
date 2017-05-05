<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.CreateConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>User Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<h2>
			Welcome
			<%=session.getAttribute("name")%></h2>
		<a  class="btn btn-info" href="logoutServlet" style="float: right">LogOut</a>
		<table>
			<tr>
				<td><form action="addTechtalk.jsp" method="post">
						<input type="submit" class="btn btn-success" value="Add TechTalk" />
					</form></td>
			</tr>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th>Date</th>
					<th>Title</th>
					<th>Description</th>
					<th>Presentor</th>
				</tr>
			</thead>
			<%
try
{
Connection connection=CreateConnection.getConnection();
String query="select * from techTalkdetails";
Statement stmt=connection.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
	
%>
			<%session.setAttribute("id", rs.getInt(1));
			int id=rs.getInt(1);
    	 %>
			<tr class="info">
				<td><%=rs.getDate("presentationDate")%></td>
				<td><%=rs.getString("title") %></td>
				<td><%=rs.getString("description") %></td>
				<td><%=rs.getString("presentor") %></td>

				<%-- <td><button name="Update" value="Update" onclick="window.location.href='techTalkUpdateServlet?id=${id}';"/></td> --%>
				<td><a class="btn btn-warning" href="updateSevlet?id=${id}" >Update</a></td>
				<td><a class="btn btn-danger" href="deleteTechtalkServlet?id=${id}">Delete</a></td>
			</tr>
			<%
			}
			}
			catch(Exception e)
  {
    e.printStackTrace();
  }%>
		</table>
	</div>

</body>
</html>

