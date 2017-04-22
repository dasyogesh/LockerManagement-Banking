
package model;
import java.sql.*;
public class DbConnect {
	static Connection cn=null;
	static String driver="com.ibm.db2.jcc.DB2Driver";
	static String url="jdbc:db2://localhost:50000/DB";
	static String user="YOGESH DAS";
	static String pass="xxbrisingr10";
	
	public static Connection dbCn(){
		try{
			Class.forName(driver);
			cn=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cn;
	}

}
