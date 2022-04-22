package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.DBConnection;

public class LogDAO {
	public ResultSet GetLogFromMaNV(int maNV) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select idLog,hoten,description,date from log inner join nhanvien nv "
					+ "on log.manv=nv.manv where log.manv=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, maNV);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet GetLogFromMaNVandDate(int maNV,Date d1,Date d2) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select idLog,hoten,description,date from log inner join nhanvien nv "
					+ "on log.manv=nv.manv where log.manv=? and date>? and date<?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, maNV);
			pstm.setDate(2, d1);
			pstm.setDate(3, d2);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ResultSet GetAllLog() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select idLog,hoten,description,date from log inner join nhanvien nv "
					+ "on log.manv=nv.manv";
			PreparedStatement pstm = con.prepareStatement(sql);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet GetAllLogDate(Date d1,Date d2) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select idLog,hoten,description,date from log inner join nhanvien nv "
					+ "on log.manv=nv.manv where date>? and date<?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDate(1, d1);
			pstm.setDate(2, d2);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet GetThongKeChung() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "call thongke()";
			PreparedStatement pstm = con.prepareStatement(sql);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet GetThongKeMuon() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "call thongkemuon()";
			PreparedStatement pstm = con.prepareStatement(sql);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ResultSet GetThongKeMuonTheoNgay(Date d1, Date d2) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "call thongkemuontheongay(?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDate(1, d1);
			pstm.setDate(2, d2);
			return pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
