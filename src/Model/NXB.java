package Model;

public class NXB {
	private String maNXB;
	private String tenNXB;
	private String diaChi="";
	private String soDT="";
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
	public NXB(String maNXB,String tenNXB,String diaChi,String sdt) {
		this.maNXB=maNXB;
		this.tenNXB=tenNXB;
		this.diaChi=diaChi;
		this.soDT=sdt;
	}
	
}
