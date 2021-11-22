package Model;

public class DocGia {
	private String maDG;
	private String tenDG;
	private String diaChi;
	private String soDT;
	public String getMaDG() {
		return maDG;
	}
	public void setMaDG(String maDG) {
		this.maDG = maDG;
	}
	public String getTenDG() {
		return tenDG;
	}
	public void setTenDG(String tenDG) {
		this.tenDG = tenDG;
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
	
	public DocGia(String tenDG,String diaChi,String soDT) {
		this.tenDG=tenDG;
		this.diaChi=diaChi;
		this.soDT=soDT;
	}
	
	public DocGia(String maDG,String tenDG,String diaChi,String soDT) {
		this.maDG=maDG;
		this.tenDG=tenDG;
		this.diaChi=diaChi;
		this.soDT=soDT;
	}
	
	
	
	
}
