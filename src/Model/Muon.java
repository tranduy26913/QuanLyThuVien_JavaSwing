package Model;

import java.sql.Date;

public class Muon {
	private String maCuon;
	private String maDG;
	private Date ngayMuon;
	private Date ngayTra;
	
	public String getMaCuon() {
		return maCuon;
	}
	public void setMaCuon(String maCuon) {
		this.maCuon = maCuon;
	}
	public String getMaDG() {
		return maDG;
	}
	public void setMaDG(String maDG) {
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
	public Muon(String maCuon, String maDG,Date ngayMuon) {
		this.maCuon=maCuon;
		this.maDG=maDG;
		this.ngayMuon=ngayMuon;
	}
	public Muon(String maCuon, String maDG,Date ngayMuon,Date ngayTra) {
		this.maCuon=maCuon;
		this.maDG=maDG;
		this.ngayMuon=ngayMuon;
		this.ngayTra=ngayTra;
	}
}
