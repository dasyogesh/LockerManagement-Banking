package controller;
import model.*;
import java.sql.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out=response.getWriter();
			Connection cn=DbConnect.dbCn();
			String sql="select * from stud1 where id=? and pass=?";
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				rd.include(request, response);
				
			}else{
				out.println("record not found");
				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				rd.include(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
