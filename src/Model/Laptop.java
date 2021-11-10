package Model;

import java.util.Scanner;


public class Laptop {
	private String maSo;
	private String hangSx;
	private String moTa;
	private float giaBan;
	
	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHangSx() {
		return hangSx;
	}

	public void setHangSx(String hangXs) {
		this.hangSx = hangXs;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	
	public Laptop() {
		
	}

	public Laptop(String maSo,String HangSx,String Mota,float giaBan) {
		this.maSo=maSo;
		this.hangSx=HangSx;
		this.moTa=Mota;
		this.giaBan=giaBan;
	}
	
	
}
