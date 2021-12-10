package Model;

import java.sql.Date;

public class Log {
	private int idLog;
	private int maNV;
	private String description="";
	private Date date;
	public int getIdLog() {
		return idLog;
	}
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Log() {
		
	}
	public Log(int manv,String des,Date date) {
		this.maNV=manv;
		this.description=des;
		this.date=date;
	}
	public Log(int idlog,int manv,String des,Date date) {
		this.idLog=idlog;
		this.maNV=manv;
		this.description=des;
		this.date=date;
	}
}
