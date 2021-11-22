package Model;
import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
public class DocGiaDAO {
	
	public void Insert(DocGia dg) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO DocGia(TenDG,DiaChi,SoDT) VALUES( ?, ?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, dg.getTenDG());
		pstm.setString(2, dg.getDiaChi());
		pstm.setString(3, dg.getSoDT());
		pstm.execute();
		System.out.println("Thành công");
		
	}
	
	public void Update(DocGia dg) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "UPDATE DocGia SET tenDG=?, diachi=?, sodt=? where madg=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, dg.getTenDG());
		pstm.setString(2, dg.getDiaChi());
		pstm.setString(3, dg.getSoDT());
		pstm.setString(4, dg.getMaDG());
		pstm.executeUpdate();
		System.out.println("Thành công");
		
	}
	
	public DocGia GetDocGiaFromMaDG(String maDG) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM DocGia Where maDG=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, maDG);
		ResultSet rs = pstm.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return new DocGia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
	}
	
	public ResultSet GetDocGiaFromInfo(String p1,String p2,String p3,String p4) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM DocGia where madg like ? and"
				+ " tendg like ? and diachi like ? and sodt like ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, '%'+p1+'%');
		pstm.setString(2, '%'+p2+'%');
		pstm.setString(3, '%'+p3+'%');
		pstm.setString(4, '%'+p4+'%');
		return pstm.executeQuery();
	}
	
	public void DeleteDocGiaFromMaDG(String MaDG) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="DELETE FROM DocGia Where maDG=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, MaDG);
		pstm.executeUpdate();
		System.out.println("Thành công");
	}
	
	public ResultSet GetAllDocGia() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM DocGia";
		PreparedStatement pstm = con.prepareStatement(sql);
		return pstm.executeQuery();
		
	}
	
	
	
}
