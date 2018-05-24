package com.divyanshu.ChatterBoxBackend.model;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="FriendRequest")
public class FriendRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int friendRequestId;
	private String fromEmailId;
	private String toEmailId;
	private String requestStatus;
	
	 public FriendRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getFriendRequestId() {
		return friendRequestId;
	}

	public String getFromEmailId() {
		return fromEmailId;
	}

	public String getToEmailId() {
		return toEmailId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setFriendRequestId(int friendRequestId) {
		this.friendRequestId = friendRequestId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	 
	}