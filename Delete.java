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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			String id=request.getParameter("id");
			Connection cn=DbConnect.dbCn();
			String sql="select id from stud1 where id=?";
			String sql1="delete from stud1 where id=?";
			
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				PreparedStatement ps1=cn.prepareStatement(sql1);
				ps1.setString(1, id);
				ps1.execute();
				out.print("Record deleted");
				RequestDispatcher rd=request.getRequestDispatcher("delete.html");
				rd.include(request, response);
			}else{
				out.println("id not found");
				RequestDispatcher rd=request.getRequestDispatcher("delete.html");
				rd.include(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
