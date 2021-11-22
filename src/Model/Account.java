package Model;

public class Account {
	private String username;
	private String password;
	private String typeUser;
	private String maNV;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	public Account(String user,String pw){
		this.username=user;
		this.password=pw;
	}
	public Account(String user,String pw,String type){
		this.username=user;
		this.password=pw;
		this.typeUser=type;
	}
	public Account(String user,String pw,String type,String manv){
		this.username=user;
		this.password=pw;
		this.typeUser=type;
		this.maNV=manv;
	}
	
}
