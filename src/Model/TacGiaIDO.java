package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import DAO.DBConnection;

public class TacGiaIDO {
	public boolean Insert(TacGia tacgia) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO TacGia VALUES(?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, tacgia.getMaSach());
		pstm.setString(2,tacgia.getTenTacGia());
		return pstm.execute();
		
	}
	
	public boolean Update(NXB nxb) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "UPDATE NXB SET TenNXB=?, DiaChi=?, SoDT=? where MaNXB=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, nxb.getTenNXB());
		pstm.setString(2, nxb.getDiaChi());
		pstm.setString(3, nxb.getSoDT());
		pstm.setString(4, nxb.getMaNXB());
		if( pstm.executeUpdate()>0)
			return true;
		return false;
		
	}
	
	public boolean Delete(NXB nxb) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Delete from NXB where MaNXB=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, nxb.getMaNXB());
		if( pstm.executeUpdate()>0)
			return true;
		return false;
	}
}
