package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

/**
 * Class containing attributes of the employee entity
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "code")
	private int code;
	@NonNull
	@Pattern(regexp = "^([a-zA-Z]{2,})$", message = "Enter valid first name")
	@Column(name = "first_name")
	private String firstName;
	@Pattern(regexp = "^([a-zA-Z]{2,})$", message = "Enter a valid name")
	@Column(name = "middle_name")
	private String middleName;
	@NonNull
	@Pattern(regexp = "^([a-zA-Z]{2,})$", message = "Enter a valid last name")
	@Column(name = "last_name")
	private String lastName;
	@NotNull
	@Column(name = "dob")
	private Date dob;
	@NotNull
	@Column(name = "gender")
	private String gender;
	@NotNull
	@Pattern(regexp = "^(\\w+([\\.-]?\\w+)*@[a-zA-Z]+(\\.[a-zA-Z]{2,3})+)$", message = "Enter a valid email")
	@Column(name = "email")
	private String emailId;
	@NotNull
	@Pattern(regexp = "^([0-9]{8,12})$", message = "Enter a valid contact")
	@Size(min = 8, max = 10)
	@Column(name = "contact")
	private String contact;
	@Column(name = "skype_id")
	private String skypeId;
	@Column(name = "profile_picture")
	private String profilePicture;
	@Pattern(regexp = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{8,})$", message = "Enter a valid password")
	@Column(name = "password")
	private String password;
	// @Column(name = "skills")
	// private String skills;
	@Column(name = "token")
	private String token;

	@Column(name = "enabled")
	private String enabled = "true";

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//
	// public String getSkills() {
	// return skills;
	// }
	//
	// public void setSkills(String skills) {
	// this.skills = skills;
	// }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
