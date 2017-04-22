<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession(false);
String user=(String)session.getAttribute("user");


%>
<table align="right">
<tr><td>Hello </td><td><%=user%></td>
</table>
<%@page import="java.sql.*,model.*,java.util.*" %>
<table border="4">
<tr><th>UserId</th><th>Password</th>
	<th>User Name</th><th>Full Address</th>
	<th>Date Of Opening</th><th>Status</th>
</tr>
<%
try{
	String id=(String)session.getAttribute("id");

		Connection cn=DbConnect.dbCn();
	String sql="select * from stud1 where id=?";
	PreparedStatement ps=cn.prepareStatement(sql);
	ps.setString(1, id);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td><td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td><td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td><td><%=rs.getString(6) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	e.printStackTrace();
} %>
</table>
<form method="get" action="ShowId.jsp">
    <button type="submit" >HOME-PAGE</button>
</form>
</body>
</html>