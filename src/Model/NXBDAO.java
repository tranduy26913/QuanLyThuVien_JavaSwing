package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DBConnection;

public class NXBDAO {
	public boolean Insert(NXB nxb) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO NXB(tennxb,diachi,sodt) VALUES(?, ?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, nxb.getTenNXB());
		pstm.setString(2, nxb.getDiaChi());
		pstm.setString(3, nxb.getSoDT());
		if(pstm.executeUpdate()>0)
			return true;
		return false;
		
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
	
	public boolean Delete(String maNXB) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Delete from NXB where MaNXB=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, maNXB);
		if( pstm.executeUpdate()>0)
			return true;
		return false;
	}
	
	public NXB GetNXBFromMaNXB(String manxb) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="select * from NXB where maNXB=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, manxb);
		ResultSet rs= pstm.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return new NXB(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
	}
	
	public ArrayList<NXB> GetAllNXB() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="select * from NXB";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs= pstm.executeQuery();
		ArrayList<NXB> list=new ArrayList<NXB>();
		while(rs.next()) {
			list.add(new NXB(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return list;
	}
	
}
