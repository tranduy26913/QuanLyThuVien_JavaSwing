package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.DBConnection;

public class CuonSachDAO {
	public boolean Insert(CuonSach cs) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO CuonSach(maSach,Vitri) VALUES(?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, cs.getMaSach());
		pstm.setString(2, cs.getViTri());
		return pstm.execute();		
	}
}
