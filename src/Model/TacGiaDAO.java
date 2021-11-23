package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import DAO.DBConnection;

public class TacGiaDAO {
	
	public boolean Insert(TacGia tacgia) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO TacGia VALUES(?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, tacgia.getMaSach());
		pstm.setString(2,tacgia.getTenTacGia());
		return pstm.execute();
		
	}
	
	
	public boolean DeleteTacGiaFromMaSach(String maSach) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Delete from TacGia where MaSach=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, maSach);
		if( pstm.executeUpdate()>0)
			return true;
		return false;
	}
}
