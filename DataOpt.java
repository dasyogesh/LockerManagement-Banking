package controller;
import model.*;
import java.util.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DataOpt
 */
@WebServlet("/DataOpt")
public class DataOpt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Connection cn=DbConnect.dbCn();
			System.out.println("Database Connected...");
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String name=request.getParameter("name");
			String addr=request.getParameter("addr");
			String date=request.getParameter("date");
			String status="INACTIVE";
			String sql="insert into stud1 values(?,?,?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, addr);
			ps.setString(5, date);
			ps.setString(6, status);
			
			ps.execute();
			
			System.out.println("record inserted...."); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
