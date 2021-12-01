package Model;

public class Nguoi {
	private int ma;
	private String tenString;
	private String diaChiString;
	private String SDT;
	
	public String getDiaChiString() {
		return diaChiString;
	}
	public int getMa() {
		return ma;
	}
	public String getSDT() {
		return SDT;
	}
	public String getTenString() {
		return tenString;
	}
	public void setDiaChiString(String diaChiString) {
		this.diaChiString = diaChiString;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public void setTenString(String tenString) {
		this.tenString = tenString;
	}
	public Nguoi() {
		
	}
	public Nguoi(int ma, String hotenString, String diachiString, String sdt)
	{
		this.ma= ma;
		this.tenString=hotenString;
		this.diaChiString= diachiString;
		this.SDT=sdt;
	}
	
}
