<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Update">
<%@page import="java.sql.*,model.*,java.util.*" %>
<%
session=request.getSession(false);
String user=(String)session.getAttribute("user");


%>
<table align="right">
<tr><td>Hello </td><td><%=user%></td>
</table>
<%
try{
	String id=(String)session.getAttribute("id");
	Connection cn=DbConnect.dbCn();
	String sql="select pass,addr from stud where id=?";
	PreparedStatement ps=cn.prepareStatement(sql);
	ps.setString(1, id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
%>
<table align="center">
<tr><td>Your Password :</td><td><input type="text" name="pass" value=<%=rs.getString(1) %>></td></tr>
<tr><td>Your Address:</td><td><input type="text" name="addr" value=<%=rs.getString(2) %>></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Update"></td></tr>
</table>
<%} %>
<%}catch(Exception e){
	e.printStackTrace();
} %>
</form>
</body>
</html>