package com.divyanshu.ChatterBoxBackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name= "Forum")
public class Forum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumId;
	@Column(unique=true)
	private String forumName;
	private String forumPost;
	private int forumLikes;
	private String userEmailId;
	private String status;
	private Date forumDate;
	public int getForumId() {
	return forumId;
	}
	public String getForumPost() {
		return forumPost;
	}
	public int getForumLikes() {
		return forumLikes;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public String getStatus() {
		return status;
	}
	public Date getForumDate() {
		return forumDate;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public void setForumPost(String forumPost) {
		this.forumPost = forumPost;
	}
	public void setForumLikes(int forumLikes) {
		this.forumLikes = forumLikes;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}
	
public Forum() {
	// TODO Auto-generated constructor stub
}
public String getForumName() {
	return forumName;
}
public void setForumName(String forumName) {
	this.forumName = forumName;
}	

}
