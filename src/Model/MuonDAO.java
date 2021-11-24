package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DBConnection;

public class MuonDAO {
	public boolean Insert(Muon muon) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO Muon VALUES(?, ?,?,?)";
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
}
