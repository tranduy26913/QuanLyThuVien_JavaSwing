package Model;

import java.sql.Date;

public class Muon {
	private int maCuon;
	private int maDG;
	private Date ngayMuon;
	private Date ngayTra;
	
	public int getMaCuon() {
		return maCuon;
	}
	public void setMaCuon(int maCuon) {
		this.maCuon = maCuon;
	}
	public int getMaDG() {
		return maDG;
	}
	public void setMaDG(int maDG) {
		this.maDG = maDG;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public Muon(int maCuon, int maDG,Date ngayMuon) {
		this.maCuon=maCuon;
		this.maDG=maDG;
		this.ngayMuon=ngayMuon;
	}
	public Muon(int maCuon, int maDG,Date ngayMuon,Date ngayTra) {
		this.maCuon=maCuon;
		this.maDG=maDG;
		this.ngayMuon=ngayMuon;
		this.ngayTra=ngayTra;
	}
}
