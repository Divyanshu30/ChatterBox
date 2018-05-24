package com.divyanshu.ChatterBoxBackend.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="ForumComments")
public class ForumComments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  forumCommentId;
	private int forumId;
	private String forumComment;
	private String forumCommenterEmailId;
	private int forumLikes;
	private String forumStatus;
	public int getForumCommentId() {
		return forumCommentId;
	}
	public int getForumId() {
		return forumId;
	}
	public String getForumComment() {
		return forumComment;
	}
	public String getForumCommenterEmailId() {
		return forumCommenterEmailId;
	}
	public int getLikes() {
		return forumLikes;
	}
	public String getStatus() {
		return forumStatus;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}
	public void setForumCommenterEmailId(String forumCommenterEmailId) {
		this.forumCommenterEmailId = forumCommenterEmailId;
	}
	public void setLikes(int likes) {
		this.forumLikes = likes;
	}
	public void setStatus(String status) {
		this.forumStatus = status;
	}
public ForumComments() {
	// TODO Auto-generated constructor stub
}
	
	}
