package hh.swd20.organizer.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpForm {
	
	// Tein suomenkieliset virheilmoitukset
	
	@NotEmpty(message="Etunimi ei saa olla tyhjä!")
	@Size(min=2, max=30, message="Etunimen pitää olla 2-30 merkkiä pitkä!")
	private String firstname = "";
	
	@NotEmpty(message="Sukunimi ei saa olla tyhjä!")
	@Size(min=2, max=40, message="Sukunimen pitää olla 2-40 merkkiä pitkä!")
	private String lastname = "";
	
	@NotEmpty(message="Sukupuoli ei voi olla tyhjä!")
	@Size(min=4, max=6, message="Sukupuoli pitää olla mies tai nainen")
	private String gender ="";
	
	@NotEmpty(message="Käyttäjänimi ei saa olla tyhjä!")
	@Size(min=4, max=30, message="Käyttäjänimi pitää olla 4-30 merkkiä pitkä!")
	private String username = "";
	
	@NotEmpty(message="Salasana ei saa olla tyhjä!")
	@Size(min=4, max = 20, message="Salasanan pitää olla 4-20 merkkiä pitkä!")
	private String password = "";
	
	@NotEmpty(message="Salasana ei saa olla tyhjä")
	@Size(min=4, max=20, message="Salasanan pitää olla 4-20 merkkiä pitkä!")
	private String passwordCheck = "";
	
	@NotEmpty(message="Sähköposti ei saa olla tyhjä!")
	@Size(min=15, max=60, message="Sähköpostin pitää olla 15-60 merkkiä pitkä!")
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
