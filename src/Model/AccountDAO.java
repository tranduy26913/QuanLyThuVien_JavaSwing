package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DBConnection;

public class AccountDAO {
	public void Insert(Account acc) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO Account VALUES(?, ?, ?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, acc.getUsername());
		pstm.setString(2, acc.getPassword());
		pstm.setString(3, acc.getTypeUser());
		pstm.setString(4, acc.getMaNV());
		pstm.execute();
		System.out.println("Thành công");
		
	}
	
	public boolean Login(Account acc) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Select * from account where username=? and password=? and typeuser=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, acc.getUsername());
		pstm.setString(2, acc.getPassword());
		pstm.setString(3, acc.getTypeUser());
		ResultSet rs=pstm.executeQuery();
		if(rs.next())
			return true;
		return false;	
	}
	
	
}
