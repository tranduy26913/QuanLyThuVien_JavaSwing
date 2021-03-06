package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.exceptions.RSAException;

import DAO.DBConnection;

public class MuonDAO {
	public boolean Insert(Muon muon) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		try {

			String sql = "INSERT INTO Muon(macuon,madg,ngaymuon,ngaytra) VALUES(?, ?,?,?)";
			con.setAutoCommit(false);
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, muon.getMaCuon());
			pstm.setInt(2, muon.getMaDG());
			pstm.setDate(3, muon.getNgayMuon());
			pstm.setDate(4, muon.getNgayTra());
			if (pstm.executeUpdate() > 0) {
				pstm = con.prepareStatement("update cuonsach set trangthai=? where macuon=?");
				pstm.setString(1, "Đã mượn");
				pstm.setInt(2, muon.getMaCuon());
				int i = pstm.executeUpdate();
				try {
					pstm = con.prepareStatement("INSERT INTO Log(manv,description,date)"
							+ " VALUES(?, ?,now())");
					pstm.setInt(1, Global.getMaNV());
					pstm.setString(2,"Thao tác cho mượn sách (Mã cuốn:"+muon.getMaCuon()
					+";(Mã độc giả:"+muon.getMaDG()+")");
					pstm.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
				con.commit();
				con.close();
				return i > 0 ? true : false;
			}
			con.rollback();
			return false;
		} catch (Exception e) {
			con.rollback();
			con.close();
			return false;
		}

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

	public boolean TraSach(Muon muon) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		try {
			con.setAutoCommit(false);
			String sql = "Update Muon set ngaytra=? where madg=? and macuon=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDate(1, muon.getNgayTra());
			pstm.setInt(2, muon.getMaDG());
			pstm.setInt(3, muon.getMaCuon());
			if (pstm.executeUpdate() > 0) {
				pstm = con.prepareStatement("Update CuonSach set TrangThai=? where macuon=?");
				pstm.setString(1, "Chưa mượn");
				pstm.setInt(2, muon.getMaCuon());
				int i = pstm.executeUpdate();
				if (i > 0) {
					try {
						pstm = con.prepareStatement("INSERT INTO Log(manv,description,date)"
								+ " VALUES(?, ?,now())");
						pstm.setInt(1, Global.getMaNV());
						pstm.setString(2,"Thao tác trả sách (Mã cuốn:"+muon.getMaCuon()
						+";(Mã độc giả:"+muon.getMaDG()+")");
						pstm.executeUpdate();
					} catch (Exception e) {
						// TODO: handle exception
					}
					con.commit();
					con.close();
					return true;
				} else {
					con.rollback();
					con.close();
					return false;
				}
			}
			con.rollback();
			con.close();
			return false;
			

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			con.close();
			return false;
		}
	}

	public boolean GiaHanSach(Muon muon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "Update Muon set ngaymuon=? where madg=? and macuon=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDate(1, muon.getNgayMuon());
			pstm.setInt(2, muon.getMaDG());
			pstm.setInt(3, muon.getMaCuon());
			if(pstm.executeUpdate() > 0) {
				try {
					pstm = con.prepareStatement("INSERT INTO Log(manv,description,date)"
							+ " VALUES(?, ?,now())");
					pstm.setInt(1, Global.getMaNV());
					pstm.setString(2,"Thao tác cho gia hạn sách (Mã cuốn:"+muon.getMaCuon()
					+";(Mã độc giả:"+muon.getMaDG()+")");
					pstm.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return true;
			}
			return false;

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
			ResultSet rs = pstm.executeQuery();
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

	public ResultSet GetDangMuon(int maDG, int maCuon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select m.macuon MaCuon, ds.tuasach TuaSach, m.ngaymuon,m.ngaytra from "
					+ "muon m inner join cuonsach cs on m.macuon=cs.macuon "
					+ "inner join dausach ds on ds.masach=cs.masach "
					+ "where m.madg=? and m.macuon=? and ngaytra is null";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, maDG);
			pstm.setInt(2, maCuon);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean CheckDaMuonDauSach(String maCuon, String maDG) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "Select count(*) from muon m inner join cuonsach cs on m.MaCuon=cs.MaCuon"
					+ " where cs.MaSach=any (select cs2.MaSach from cuonsach cs2 where cs2.MaCuon=?)"
					+ " and m.NgayTra is null and maDG=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, maCuon);
			pstm.setString(2, maDG);
			ResultSet rs= pstm.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0)
					return true;
				return false;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
				return false;
		}
	}
	
	public boolean CheckCuonSachDaMuon(int maCuon) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select count(*) from muon where macuon=? and ngaytra is null";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, maCuon);
			ResultSet rs= pstm.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0)
					return true;
				return false;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
				return false;
		}
	}
}
