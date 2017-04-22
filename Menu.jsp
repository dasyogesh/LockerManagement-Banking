<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
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
<form method="get" action="Insert.html">
    <button type="submit" >ADD LOCKER</button>
</form>
<form method="get" action="delete.html">
    <button type="submit" >CLOSE LOCKER</button>
</form>
<form method="get" action="ShowAll.jsp">
    <button type="submit" >DISPLAY ALL LOCKERS</button>
</form>
</body>
</html>