package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DBConnection;

public class CuonSachDAO {
	public boolean Insert(CuonSach cs) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO CuonSach(maSach,Vitri,TrangThai) VALUES(?, ?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, cs.getMaSach());
		pstm.setString(2, cs.getViTri());
		pstm.setString(3, cs.getTrangThai());
		return pstm.execute();		
	}
	
	public boolean Update(CuonSach cs) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Update CuonSach set vitri=? where macuon=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, cs.getViTri());
		pstm.setInt(1, cs.getMaCuonSach());
		
		return pstm.executeUpdate()>0?true:false;	
			
	}
	public boolean Delete(int macuon) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "Delete from Muon where macuon=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, macuon);
		if(pstm.executeUpdate()>0) {
			sql = "Delete from CuonSach where macuon=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, macuon);
		return pstm.executeUpdate()>0?true:false;	
		}
		return false;
			
	}
	
	public ResultSet GetAllCuonSachChuaMuon() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "select cs.macuon,temp.tuasach,tacgia,nxb from (select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "
				+'"'+'-'+'"'+") tacgia,nxb.tennxb nxb "
				+ "from dausach ds left join tacgia tg on ds.masach=tg.masach "
				+ "inner join nxb on ds.manxb=nxb.manxb "
				+ "group by ds.masach) temp inner join cuonsach cs "
				+ "on temp.masach=cs.MaSach "
				+ "where cs.TrangThai=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, "Chưa mượn");
		return pstm.executeQuery();
	}
	
	public ResultSet GetAllCuonSach() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "call GetAllCuonSach()";
		PreparedStatement pstm = con.prepareStatement(sql);
		return pstm.executeQuery();
	}

}
