package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DBConnection;

public class NXBDAO {
	public void Insert(NXB nxb) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO NXB VALUES(?, ?, ?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, nxb.getMaNXB());
		pstm.setString(2, nxb.getTenNXB());
		pstm.setString(3, nxb.getDiaChi());
		pstm.setString(4, nxb.getSoDT());
		pstm.execute();
		System.out.println("Thành công");
		
	}
	
	public void Update(DauSach sp) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "UPDATE DauSach SET Tua=?, MaNXB=? where maSach=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, sp.getTua());
		pstm.setString(2, sp.getTua());
		pstm.setString(3, sp.getMaSach());
		pstm.executeUpdate();
		System.out.println("Thành công");
		
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
