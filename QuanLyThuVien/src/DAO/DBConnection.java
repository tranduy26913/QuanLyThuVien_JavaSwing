package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ThuVien";
		//String pw="123456@abc";
		String pw ="22112000Lvc@";
		String user="root";
		Connection con=DriverManager.getConnection(url, user, pw);
		return con;
		
	}
}
