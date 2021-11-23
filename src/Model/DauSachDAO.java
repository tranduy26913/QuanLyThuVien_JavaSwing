package Model;

import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;

public class DauSachDAO {

	public boolean Insert(DauSach sp) throws ClassNotFoundException, SQLException {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "INSERT INTO DauSach VALUES(?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, sp.getMaSach());
			pstm.setString(2, sp.getTua());
			pstm.setString(3, sp.getMaNXB());
			if (pstm.execute()) {
				pstm = con.prepareStatement("INSERT INTO TacGia VALUES(?, ?)");
				String ds[] = sp.getTacGia().split("\n");
				for (int i = 0; i < ds.length; i++) {
					pstm.setString(1, sp.getMaSach());
					pstm.setString(2, ds[i]);
					pstm.execute();
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean Update(DauSach ds) throws ClassNotFoundException, SQLException {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "UPDATE DauSach SET TuaSach=?, MaNXB=? where maSach=?";
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setString(1, ds.getTua());
			pstm.setString(2, ds.getMaNXB());
			pstm.setString(3, ds.getMaSach());
			pstm.executeUpdate();

			pstm = con.prepareStatement("Delete from TacGia where MaSach=?");
			pstm.setString(1, ds.getMaSach());
			pstm.executeUpdate();

			pstm = con.prepareStatement("INSERT INTO TacGia VALUES(?, ?)");
			String tg[] = ds.getTacGia().split("\n");
			for (int i = 0; i < tg.length; i++) {
				pstm.setString(1, ds.getMaSach());
				pstm.setString(2, tg[i]);
				pstm.execute();
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean Delete(String maSach) throws ClassNotFoundException, SQLException {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("Delete from TacGia where MaSach=?");
			pstm.setString(1, maSach);
			pstm.executeUpdate();

			pstm = con.prepareStatement("Delete from CuonSach where maSach=?");
			pstm.setString(1, maSach);
			pstm.executeUpdate();
			
			pstm = con.prepareStatement("Delete from DauSach where maSach=?");
			pstm.setString(1, maSach);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public ResultSet GetDauSachFromMaSach(String maso) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator '-') tacgia,nxb.tennxb nxb "
				+ "from dausach ds inner join tacgia tg on ds.masach=tg.masach "
				+ "inner join nxb on ds.manxb=nxb.manxb where ds.masach=? group by ds.masach";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, maso);
		return pstm.executeQuery();
	}

	public ResultSet GetAllDauSach() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator '-') tacgia,nxb.tennxb nxb "
				+ "from dausach ds inner join tacgia tg on ds.masach=tg.masach "
				+ "inner join nxb on ds.manxb=nxb.manxb group by ds.masach";
		PreparedStatement pstm = con.prepareStatement(sql);
		return pstm.executeQuery();
	}

}
