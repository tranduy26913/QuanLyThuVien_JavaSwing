package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.CompactNumberFormat;
import java.util.ArrayList;

import DAO.DBConnection;

public class NhanVienDAO {
	public boolean Insert(NhanVien nv, String type) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getConnection();
		connection.setAutoCommit(false);
		String sqlString = "Insert into nhanvien(hoten,diachi,sdt,luong) values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		preparedStatement.setString(1, nv.getHoTen());
		preparedStatement.setString(2, nv.getDiaChi());
		preparedStatement.setString(3, nv.getSoDT());
		preparedStatement.setDouble(4, nv.getLuong());
		if (preparedStatement.executeUpdate() > 0) {
			preparedStatement = connection.prepareStatement("select last_insert_id()");
			ResultSet rSet = preparedStatement.executeQuery();
			int id = 0;
			while (rSet.next()) {
				id = rSet.getInt(1);
			}
			preparedStatement = connection.prepareStatement("insert into account values(?,?,?,?)");
			preparedStatement.setString(1, type + String.valueOf(id));
			preparedStatement.setString(2, "123");
			preparedStatement.setString(3, type);
			preparedStatement.setInt(4, id);
			if (preparedStatement.executeUpdate() > 0) {
				try {
					
					preparedStatement = connection.prepareStatement("insert into Log(manv,description,date)"
							+ " values(?,?,now())");
					preparedStatement.setInt(1, Global.getMaNV());
					preparedStatement.setString(2, "Thêm nhân viên (Mã:"+String.valueOf(id));
					preparedStatement.executeUpdate();
				}catch (Exception e) {
					// TODO: handle exception
				}
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		}
		connection.rollback();
		return false;
	}

	public boolean Update(NhanVien nv) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getConnection();
		String sqlString = "Update nhanvien set hoten=?, diachi=?, sdt=?, luong=? where manv=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

		preparedStatement.setString(1, nv.getHoTen());
		preparedStatement.setString(2, nv.getDiaChi());
		preparedStatement.setString(3, nv.getSoDT());
		preparedStatement.setDouble(4, nv.getLuong());
		preparedStatement.setInt(5, nv.getMa());
		if (preparedStatement.executeUpdate() > 0) {
			try {
				
				preparedStatement = connection.prepareStatement("insert into Log(manv,description,date)"
						+ " values(?,?,now())");
				preparedStatement.setInt(1, Global.getMaNV());
				preparedStatement.setString(2, "Sửa thông tin nhân viên (Mã:"+String.valueOf(nv.getMa()));
				preparedStatement.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
			}
			return true;
		}
			
		return false;
	}

	public boolean Delete(int manv) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		con.setAutoCommit(false);
		try {
			String sql = "Delete from account where manv=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, manv);
			if (pstm.executeUpdate() > 0)
			{
				pstm = con.prepareStatement("Delete from nhanvien where manv=?");
				pstm.setInt(1, manv);
				if(pstm.executeUpdate()>0) {
					try {
						pstm = con.prepareStatement("insert into Log(manv,description,date)"
								+ " values(?,?,now())");
						pstm.setInt(1, Global.getMaNV());
						pstm.setString(2, "Xoá nhân viên (Mã:"+String.valueOf(manv));
						pstm.executeUpdate();
					}catch (Exception e) {
						// TODO: handle exception
					}
					con.commit();
					return true;
				}
				else {
					con.rollback();
					return false;
				}
			}
			con.rollback();
			return false;
		} catch (Exception e) {
			con.rollback();
			return false;
		}

	}

	public ArrayList<NhanVien> GetAllNhanVien() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "select * from nhanvien";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		while (rs.next()) {
			list.add(new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
		}
		return list;
	}

	public NhanVien layThongTinNhanVien(int mnv) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "select * from nhanvien";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
		return nv;
	}
}
