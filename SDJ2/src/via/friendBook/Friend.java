package via.friendBook;

public class Friend {

	private String fName;
	private String lName;
	private int phoneNo;
	private String email;
	
	public Friend (String fName, String lName, int phoneNo, String email) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
