package Model;

public class CuonSach {
	private int maCuonSach;
	private String maSach;
	private String viTri="";
	public int getMaCuonSach() {
		return maCuonSach;
	}
	public void setMaCuonSach(int maCuonSach) {
		this.maCuonSach = maCuonSach;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	
	public CuonSach(String maSach) {
		this.maSach=maSach;
	}
	
	public CuonSach(String maSach, String vitri) {
		this.maSach=maSach;
		this.viTri=vitri;
	}
	
	public CuonSach(int maCuon, String vitri) {
		this.maCuonSach=maCuon;
		this.viTri=vitri;
	}
	
}
