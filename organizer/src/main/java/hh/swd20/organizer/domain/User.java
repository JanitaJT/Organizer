package hh.swd20.organizer.domain;

public class User {
	
	private Long usId;
	private String uFirstname;
	private String uLastname;
	private String uFemale;
	private String uMale;
	private String userName;
	private String userPassword;
	private String uEmail;
	public User(Long usId, String uFirstname, String uLastname, String uFemale, String uMale, String userName,
			String userPassword, String uEmail) {
		super();
		this.usId = usId;
		this.uFirstname = uFirstname;
		this.uLastname = uLastname;
		this.uFemale = uFemale;
		this.uMale = uMale;
		this.userName = userName;
		this.userPassword = userPassword;
		this.uEmail = uEmail;
	}
	public User(String uFirstname, String uLastname, String uFemale, String uMale, String userName, String userPassword,
			String uEmail) {
		super();
		this.uFirstname = uFirstname;
		this.uLastname = uLastname;
		this.uFemale = uFemale;
		this.uMale = uMale;
		this.userName = userName;
		this.userPassword = userPassword;
		this.uEmail = uEmail;
	}
	
	public User() {
		super();
		this.usId = null;
		this.uFirstname = null;
		this.uLastname = null;
		this.uFemale = null;
		this.uMale = null;
		this.userName = null;
		this.userPassword = null;
		this.uEmail = null;
	}
	public Long getUsId() {
		return usId;
	}
	public void setUsId(Long usId) {
		this.usId = usId;
	}
	public String getuFirstname() {
		return uFirstname;
	}
	public void setuFirstname(String uFirstname) {
		this.uFirstname = uFirstname;
	}
	public String getuLastname() {
		return uLastname;
	}
	public void setuLastname(String uLastname) {
		this.uLastname = uLastname;
	}
	public String getuFemale() {
		return uFemale;
	}
	public void setuFemale(String uFemale) {
		this.uFemale = uFemale;
	}
	public String getuMale() {
		return uMale;
	}
	public void setuMale(String uMale) {
		this.uMale = uMale;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	@Override
	public String toString() {
		return "User [usId=" + usId + ", uFirstname=" + uFirstname + ", uLastname=" + uLastname + ", uFemale=" + uFemale
				+ ", uMale=" + uMale + ", userName=" + userName + ", userPassword=" + userPassword + ", uEmail="
				+ uEmail + "]";
	}
	
	
	

}
