package Model;
import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
public class DauSachDAO {
	
	public void Insert(DauSach sp) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO DauSach VALUES(?, ?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, sp.getMaSach());
		pstm.setString(2, sp.getTua());
		pstm.setString(3, sp.getMaNXB());
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
	
	public ResultSet GetDauSachFromMaSach(String maso) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator '-') tacgia,nxb.tennxb nxb "
				+ "from dausach ds inner join tacgia tg on ds.masach=tg.masach "
				+ "inner join nxb on ds.manxb=nxb.manxb where ds.masach=? group by ds.masach";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, maso);
		return pstm.executeQuery();
	}
	
	public ResultSet GetAllDauSach() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator '-') tacgia,nxb.tennxb nxb "
				+ "from dausach ds inner join tacgia tg on ds.masach=tg.masach "
				+ "inner join nxb on ds.manxb=nxb.manxb group by ds.masach";
		PreparedStatement pstm = con.prepareStatement(sql);
		return pstm.executeQuery();
	}
	
	public void DeleteLaptopFromMaSo(String maso) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="DELETE FROM Laptop Where MaSo=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, maso);
		pstm.executeUpdate();
		System.out.println("Thành công");
	}
	
	
	
	
}
