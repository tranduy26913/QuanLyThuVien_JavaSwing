package Model;

public class DocGia extends Nguoi{
	
	public DocGia(String tenDG,String diaChi,String soDT) {
		this.hoTen=tenDG;
		this.diaChi=diaChi;
		this.soDT=soDT;
	}
	
	public DocGia(int maDG,String tenDG,String diaChi,String soDT) {
		this.ma=maDG;
		this.hoTen=tenDG;
		this.diaChi=diaChi;
		this.soDT=soDT;
	}
	
}
