package Model;
import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
public class KhachHangDAO {
	
	public void Insert(KhachHang kh) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO Customer VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, kh.getID());
		pstm.setString(2, kh.getName());
		pstm.setString(3, kh.getAddress());
		pstm.setString(4, kh.getEmail());
		pstm.setString(5, kh.getPhone());
		pstm.execute();
		System.out.println("Thành công");
		
	}
	
	public void Update(KhachHang kh) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "UPDATE Customer SET Name=?, Address=?, Email=?, Phone=? where ID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, kh.getName());
		pstm.setString(2, kh.getAddress());
		pstm.setString(3, kh.getEmail());
		pstm.setString(4, kh.getPhone());
		pstm.setString(5, kh.getID());
		pstm.executeUpdate();
		System.out.println("Thành công");
		
	}
	
	public KhachHang GetKhachHangFromID(String ID) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Customer Where ID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, ID);
		ResultSet rs = pstm.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return new KhachHang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	}
	
	public void DeleteKhachHangFromID(String ID) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="DELETE FROM Customer Where ID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, ID);
		pstm.executeUpdate();
		System.out.println("Thành công");
	}
	
	public ArrayList<KhachHang> GetAllKhachHang() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Customer";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<KhachHang> list=new ArrayList<KhachHang>();
		while(rs.next()) {
			list.add(new KhachHang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return list;
	}
	
	public ArrayList<KhachHang> GetAllKhachHangFromID(String ID) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Customer where ID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, ID);
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<KhachHang> list=new ArrayList<KhachHang>();
		while(rs.next()) {
			list.add(new KhachHang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return list;
	}
	
	public ArrayList<KhachHang> GetAllKhachHangFromTen(String name) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Customer where Name LIKE ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1,'%'+ name+'%');
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<KhachHang> list=new ArrayList<KhachHang>();
		while(rs.next()) {
			list.add(new KhachHang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return list;
	}
	
	public ArrayList<KhachHang> GetAllKhachHangFromDiaChi(String addr) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Customer where Address LIKE ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, '%'+addr+'%');
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<KhachHang> list=new ArrayList<KhachHang>();
		while(rs.next()) {
			list.add(new KhachHang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return list;
	}
	
}
