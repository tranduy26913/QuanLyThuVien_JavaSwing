package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DBConnection;

public class MuonDAO {
	public boolean Insert(Muon muon) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO Muon(macuon,madg,ngaymuon,ngaytra) VALUES(?, ?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, muon.getMaCuon());
		pstm.setString(2, muon.getMaDG());
		pstm.setDate(3, muon.getNgayMuon());
		pstm.setDate(4, muon.getNgayTra());

		return pstm.executeUpdate() > 0 ? true : false;
	}

	public ResultSet GetDanhSachMuonFromMaDG(String maDG) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select m.macuon MaCuon, ds.tuasach TuaSach, m.ngaymuon,m.ngaytra from "
					+ "muon m inner join cuonsach cs on m.macuon=cs.macuon "
					+ "inner join dausach ds on ds.masach=cs.masach " + "where m.madg=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, maDG);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet GetDanhSachDangMuonFromMaDG(String maDG) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select m.macuon MaCuon, ds.tuasach TuaSach, m.ngaymuon,m.ngaytra from "
					+ "muon m inner join cuonsach cs on m.macuon=cs.macuon "
					+ "inner join dausach ds on ds.masach=cs.masach " + "where m.madg=? and ngaytra is null";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, maDG);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean TraSach(Muon muon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "Update Muon set ngaytra=? where madg=? and macuon=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDate(1, muon.getNgayTra());
			pstm.setString(2, muon.getMaDG());
			pstm.setString(3, muon.getMaCuon());
			return pstm.executeUpdate() > 0 ? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean GiaHanSach(Muon muon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "Update Muon set ngaymuon=? where madg=? and macuon=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDate(1, muon.getNgayMuon());
			pstm.setString(2, muon.getMaDG());
			pstm.setString(3, muon.getMaCuon());
			return pstm.executeUpdate() > 0 ? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int GetGiaSach(int macuon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select giasach from cuonsach cs inner join dausach ds "
					+ "on cs.masach=ds.masach where macuon=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, macuon);
			ResultSet rs=pstm.executeQuery();
			try {
				return rs.getInt(1);
			} catch (Exception e) {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public ResultSet GetDangMuon(String maDG,String maCuon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select m.macuon MaCuon, ds.tuasach TuaSach, m.ngaymuon,m.ngaytra from "
					+ "muon m inner join cuonsach cs on m.macuon=cs.macuon "
					+ "inner join dausach ds on ds.masach=cs.masach " + "where m.madg=? and m.macuon=? and ngaytra is null";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, maDG);
			pstm.setString(2, maCuon);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
