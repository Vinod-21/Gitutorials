package com.bridgelabz.fundoo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userfundo")
public class User {

	@Id
	@Column(name = "user_Id")
	 long userId;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "user_Name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public User() {

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + "]";
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Notes> notes;

	public List<Notes> getNotes() {
		return notes;
	}

	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Label> label;

	public List<Label> getLabel() {
		return label;
	}

	public void setLabel(List<Label> label) {
		this.label = label;
	}

}
