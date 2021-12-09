package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import DAO.DBConnection;

public class TacGiaDAO {

	public boolean Insert(TacGia tacgia) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO TacGia VALUES(?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, tacgia.getMaSach());
		pstm.setString(2, tacgia.getTenTacGia());
		return pstm.execute();

	}

	public ArrayList<String> GetAllTenTG() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select distinct tentacgia from TacGia";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;

		} catch (Exception e) {
			return null;
		}

	}

	public boolean DeleteTacGiaFromMaSach(String maSach) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "Delete from TacGia where MaSach=?";
		PreparedStatement pstm = con.prepareStatement(sql);

		pstm.setString(1, maSach);
		if (pstm.executeUpdate() > 0)
			return true;
		return false;
	}
}
