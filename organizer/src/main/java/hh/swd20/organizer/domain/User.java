package hh.swd20.organizer.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usId", nullable = false, updatable = false)
	private Long usId;

	@Column(name = "uFirstname", nullable = false, updatable = false)
	private String uFirstname;

	@Column(name = "uLastname", nullable = false, updatable = false)
	private String uLastname;

	@Column(name = "gender", nullable = false, updatable = false)
	private String gender;

	@Column(name = "userName", nullable = false, unique = true)
	private String userName;

	@Column(name = "userPassword", nullable = false, updatable = false)
	private String userPassword;

	@Column(name = "uEmail", nullable = false, updatable = false)
	private String uEmail;

	@Column(name = "role", nullable = false)
	private String role;

	
	// Many to many, jotta käyttäjä pääsee käsiksi kaikkiin laatikoihin
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "User_Box", joinColumns = { @JoinColumn(name = "usId") }, inverseJoinColumns = {
			@JoinColumn(name = "boxId") })

	private Set<Box> boxes = new HashSet<>();

	public User() {

	}

	public User(String uFirstname, String uLastname, String gender, String userName, String userPassword, String uEmail,
			String role) {
		super();
		this.uFirstname = uFirstname;
		this.uLastname = uLastname;
		this.gender = gender;
		this.userName = userName;
		this.userPassword = userPassword;
		this.uEmail = uEmail;
		this.role = role;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(Set<Box> boxes) {
		this.boxes = boxes;
	}

	@Override
	public String toString() {
		return "User [usId=" + usId + ", uFirstname=" + uFirstname + ", uLastname=" + uLastname + ", gender=" + gender
				+ ", userName=" + userName + ", userPassword=" + userPassword + ", uEmail=" + uEmail + ", role=" + role
				+ "]";
	}
	
}
