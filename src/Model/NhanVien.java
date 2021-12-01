package Model;

public class NhanVien extends Nguoi{
	private double luong;
	public NhanVien(){
		
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public double getLuong() {
		return luong;
	}
	
	public NhanVien(int Ma, String tenString, String diachiString, String sdt, double luong) {
		super(Ma, tenString, diachiString, sdt);
		this.luong=luong;
	}
	
	
	
}
