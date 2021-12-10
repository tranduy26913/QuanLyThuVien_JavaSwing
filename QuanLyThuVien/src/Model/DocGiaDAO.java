package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DBConnection;
public class DocGiaDAO {
	
	public void Insert(DocGia dg) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO DocGia(TenDG,DiaChi,SoDT) VALUES( ?, ?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, dg.getHoTen());
		pstm.setString(2, dg.getDiaChi());
		pstm.setString(3, dg.getSoDT());
		pstm.execute();
		System.out.println("Th�nh c�ng");
		
	}
	
	public void Update(DocGia dg) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql = "UPDATE DocGia SET tenDG=?, diachi=?, sodt=? where madg=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, dg.getHoTen());
		pstm.setString(2, dg.getDiaChi());
		pstm.setString(3, dg.getSoDT());
		pstm.setInt(4, dg.getMa());
		pstm.executeUpdate();
		System.out.println("Th�nh c�ng");
		
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
		return new DocGia(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
		System.out.println("Th�nh c�ng");
	}
	
	public int CheckDocGiaDangMuon(String MaDG)  {
		try {
			Connection con=DBConnection.getConnection();
			String sql="select count(*) from muon m inner join docgia dg "
					+ "on m.MaDG=dg.MaDG where m.NgayTra is null and dg.madg=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, MaDG);
			ResultSet rs=pstm.executeQuery();
			int count=0;
			if(rs.next()) {
				count=rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public ResultSet GetAllDocGia() throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM DocGia";
		PreparedStatement pstm = con.prepareStatement(sql);
		return pstm.executeQuery();
		
	}
	
	public ResultSet GetDocGiaMuonQuaHan() {
		try {
			Connection con=DBConnection.getConnection();
			String sql="select dg.madg, tendg,diachi,sodt from docgia dg inner join "
					+ "(select distinct madg from muon where datediff(now(),ngaymuon)>30) t "
					+ "on dg.MaDG=t.madg";
			PreparedStatement pstm = con.prepareStatement(sql);
			return pstm.executeQuery();
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
		
	}
	
	
	
}
