package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DBConnection;

public class AccountDAO {
	public boolean Insert(Account acc) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO Account VALUES(?, ?, ?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, acc.getUsername());
		pstm.setString(2, acc.getPassword());
		pstm.setString(3, acc.getTypeUser());
		pstm.setInt(4, acc.getMaNV());
		pstm.execute();
		return pstm.execute();
		
	}
	
	public Account Login(String user,String pw,String type) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Select * from account where username=? and password=? and typeuser=? limit 1";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, user);
		pstm.setString(2, pw);
		pstm.setString(3, type);
		ResultSet rs=pstm.executeQuery();
		if(rs.next())
			return new Account(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4));
		return null;	
	}
	
	public boolean DoiMatKhau(int manv,String pwold,String pwnew) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Update account set password=? where manv=? and password=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, pwnew);
		pstm.setInt(2, manv);
		pstm.setString(3, pwold);
		return pstm.executeUpdate()>0?true:false;
	}
	
	
	public boolean Delete(int manv) throws ClassNotFoundException, SQLException{
		Connection connection = DBConnection.getConnection();
		String sqlString ="Delete from account where manv = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		preparedStatement.setInt(1, manv);
		int rs=preparedStatement.executeUpdate();
		if(rs>0)
			return true;
		return false;
	}
	
}
