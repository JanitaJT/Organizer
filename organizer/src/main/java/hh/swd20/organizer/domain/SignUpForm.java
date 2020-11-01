package hh.swd20.organizer.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpForm {
	@NotEmpty
	@Size(min=2, max=30)
	private String firstname = "";
	
	@NotEmpty
	@Size(min=2, max=40)
	private String lastname = "";
	
	@NotEmpty
	@Size(min=4, max=6)
	private String gender ="";
	
	@NotEmpty
	@Size(min=4, max=30)
	private String username = "";
	
	@NotEmpty
	@Size(min=4, max = 20)
	private String password = "";
	
	@NotEmpty
	@Size(min=4, max=20)
	private String passwordCheck = "";
	
	@NotEmpty
	@Size(min=15, max=60)
	private String email = "";
	
	@NotEmpty
	private String role = "USER";

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "SignUpForm [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", username="
				+ username + ", password=" + password + ", passwordCheck=" + passwordCheck + ", email=" + email
				+ ", role=" + role + "]";
	}
	
	
}