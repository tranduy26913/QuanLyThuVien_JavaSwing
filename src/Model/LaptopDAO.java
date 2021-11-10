package Model;
import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
public class LaptopDAO {
	
	public void Insert(Laptop sp) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO Laptop VALUES(?, ?, ?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, sp.getMaSo());
		pstm.setString(2, sp.getHangSx());
		pstm.setString(3, sp.getMoTa());
		pstm.setFloat(4, sp.getGiaBan());
		pstm.execute();
		System.out.println("Thành công");
		
	}
	
	public void Update(Laptop sp) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "UPDATE Laptop SET HangSx=?, Mota=?, GiaBan=? where maso=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, sp.getHangSx());
		pstm.setString(2, sp.getMoTa());
		pstm.setFloat(3, sp.getGiaBan());
		pstm.setString(4, sp.getMaSo());
		pstm.executeUpdate();
		System.out.println("Thành công");
		
	}
	
	public Laptop GetLaptopFromMaSo(String maso) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Laptop Where MaSo=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, maso);
		ResultSet rs = pstm.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return new Laptop(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
	}
	
	public void DeleteLaptopFromMaSo(String maso) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="DELETE FROM Laptop Where MaSo=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, maso);
		pstm.executeUpdate();
		System.out.println("Thành công");
	}
	
	public ArrayList<Laptop> GetAllLaptop() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Laptop";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<Laptop> list=new ArrayList<Laptop>();
		while(rs.next()) {
			list.add(new Laptop(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
		}
		return list;
	}
	
	
}
