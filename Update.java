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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out=response.getWriter();
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String addr=request.getParameter("addr");
			String sql="update stud1 set pass=?,addr=? where id=?";
			Connection cn=DbConnect.dbCn();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, addr);
			ps.setString(3, id);
			
			ps.execute();
			out.println("Record updated...");
			RequestDispatcher rd=request.getRequestDispatcher("update.html");
			rd.include(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
