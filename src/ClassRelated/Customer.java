package ClassRelated;

import java.io.Serializable;

public class Customer implements Serializable
{
	    private int userid;
	    private String name;
	    private String password;
	    private String address;
	    private String gender;
	    private String dobirth;
	    private String city;
	    private String doreg;
	    private String phone;
	   
	    
	public Customer(int userid,String name, String password,
			String phone,String gender,String dobirth, String city,
			String doreg,String address
		  )
		{
		    this.userid = userid;
			this.name = name;
			this.password = password;
			this.phone = phone ;
			this.gender = gender;
			this.dobirth = dobirth;
			this.city = city;
			this.doreg = doreg;
			this.address = address;
			
			
			
			
		}
	
	
	    public int getUserid() {
		    return userid;
	    }
		public String getName() {
			return name;
		}
		public String getPassword() {
			return password;
		}
		public String getAddress() {
			return address;
		}
		public String getGender() {
			return gender;
		}
		public String getDobirth() {
			return dobirth;
		}
		public String getCity() {
			return city;
		}
		public String getDoreg() {
			return doreg;
		}
		public String getPhone() {
			return phone;
		}
		
		
		public void setName(String name) {
			this.name = name;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public void setDobirth(String dobirth) {
			this.dobirth = dobirth;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setDoreg(String doreg) {
			this.doreg = doreg;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		
		
		
		
}
