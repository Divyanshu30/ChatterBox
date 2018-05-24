package com.divyanshu.ChatterBoxBackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="ForumMember")
public class ForumMember implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumMemberId;
	private int forumId;
	private String memberEmailId;
	private String forumStatus;
	private Date forumDate;
	
	
	public String getForumStatus() {
		return forumStatus;
	}

	public Date getForumDate() {
		return forumDate;
	}

	public void setForumStatus(String forumStatus) {
		this.forumStatus = forumStatus;
	}

	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}

	public ForumMember() {
		// TODO Auto-generated constructor stub
	}

	public int getForumMemberId() {
		return forumMemberId;
	}

	public int getForumId() {
		return forumId;
	}

	public String getMemberEmailId() {
		return memberEmailId;
	}

	

	public void setForumMemberId(int forumMemberId) {
		this.forumMemberId = forumMemberId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public void setMemberEmailId(String memberEmailId) {
		this.memberEmailId = memberEmailId;
	}

	
	
	
}
