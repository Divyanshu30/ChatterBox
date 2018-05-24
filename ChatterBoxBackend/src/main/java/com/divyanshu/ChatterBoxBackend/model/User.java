package com.divyanshu.ChatterBoxBackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ChatterBoxUser")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private	String userGender;
	@Column(unique=true)
	private String userEmailId;
	@Column(unique=true)
	private long userPhoneNumber;
	private String userPassword;
	private boolean userStatus;
	private Date userJoinDate;
	
	
	
	
	public Date getUserJoinDate() {
		return userJoinDate;
	}


	public void setUserJoinDate(Date userJoinDate) {
		this.userJoinDate = userJoinDate;
	}


	public String getUserGender() {
		return userGender;
	}


	public String getUserEmailId() {
		return userEmailId;
	}


	public long getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public boolean getUserStatus() {
		return userStatus;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}


	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}


	public void setUserPhoneNumber(long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}


	public User() {
	// TODO Auto-generated constructor stub
}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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



}
