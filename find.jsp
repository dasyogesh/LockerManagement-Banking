<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*,model.*,java.util.*" %>
<%
try{
	String id=request.getParameter("id");
	String sql="select name,id from stud1 where id=?";
	//String sql1="select name from stud where id=?";
	Connection cn=DbConnect.dbCn();
	PreparedStatement ps=cn.prepareStatement(sql);
	ps.setString(1, id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		session=request.getSession();
		session.setAttribute("user", rs.getString(1));
		session=request.getSession();
		session.setAttribute("id", rs.getString(2));
		RequestDispatcher rd=request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
%>
<%}else{
	out.print("id not found");
	RequestDispatcher rd=request.getRequestDispatcher("ShowId.jsp");
	rd.include(request, response);
} %>
<%}catch(Exception e){
	e.printStackTrace();
} %>
</body>
</html>