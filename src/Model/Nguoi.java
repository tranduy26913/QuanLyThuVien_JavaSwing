package Model;

public class Nguoi {
	protected int ma;
	protected String hoTen;
	protected String diaChi;
	protected String soDT;
	
	
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	public Nguoi() {
		
	}
	
	public Nguoi(String hotenString, String diachiString, String sdt)
	{
		
		this.hoTen=hotenString;
		this.diaChi= diachiString;
		this.soDT=sdt;
	}
	
	public Nguoi(int ma, String hotenString, String diachiString, String sdt)
	{
		this.ma= ma;
		this.hoTen=hotenString;
		this.diaChi= diachiString;
		this.soDT=sdt;
	}
	
}
