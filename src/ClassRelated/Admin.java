package ClassRelated;

import java.io.Serializable;

public class Admin implements Serializable
{
	 private String adminid;
	 private String adminpassword;
	public Admin(String adminid, String adminpassword) {
		super();
		this.adminid = adminid;
		this.adminpassword = adminpassword;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	 
	 
	 
}
