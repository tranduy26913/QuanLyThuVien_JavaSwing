package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DBConnection;

public class NhanVienDAO {
	public boolean Insert(NhanVien nv) throws ClassNotFoundException, SQLException{
		Connection connection = DBConnection.getConnection();
		String sqlString = "Insert into nhanvien values(?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		preparedStatement.setInt(1, nv.getMa());
		preparedStatement.setString(2, nv.getHoTen());
		preparedStatement.setString(3, nv.getDiaChi());
		preparedStatement.setString(4, nv.getSoDT());
		preparedStatement.setDouble(5, nv.getLuong());
		return preparedStatement.execute();
	}
	public boolean Update(NhanVien nv) throws ClassNotFoundException, SQLException{
		Connection connection = DBConnection.getConnection();
		String sqlString = "Update nhanvien set hoten=?, diachi=?, sdt=?, luong=? where manv=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		
		preparedStatement.setString(1, nv.getHoTen());
		preparedStatement.setString(2, nv.getDiaChi());
		preparedStatement.setString(3, nv.getSoDT());
		preparedStatement.setDouble(4, nv.getLuong());
		preparedStatement.setInt(5, nv.getMa());
		if(preparedStatement.executeUpdate()>0)
			return true;
		return false;
	}
	public boolean Delete(NhanVien nv) throws ClassNotFoundException, SQLException{
		Connection con=DBConnection.getConnection();
		String sql = "Delete from nhanvien where manv=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, nv.getMa());
		if( pstm.executeUpdate()>0)
			return true;
		return false;
	}
	public ArrayList<NhanVien> GetAllNhanVien() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="select * from nhanvien";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs= pstm.executeQuery();
		ArrayList<NhanVien> list=new ArrayList<NhanVien>();
		while(rs.next()) {
			list.add(new NhanVien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDouble(5)));
		}
		return list;
	}
	public NhanVien layThongTinNhanVien(int mnv) throws ClassNotFoundException, SQLException{
		Connection con=DBConnection.getConnection();
		String sql="select * from nhanvien";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs= pstm.executeQuery();
		NhanVien nv = new NhanVien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDouble(5)); 
		return nv;
	}
}
