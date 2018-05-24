package com.divyanshu.ChatterBoxBackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "BlogComments")
public class BlogComments implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogCommentId;
	private int blogId;
	private String blogComment;
	private String blogCommenterEmailId; 
	private int blogCommentLikes;
	private String blogCommentStatus;
	private Date blogCommentDate;

	public BlogComments() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public int getBlogId() {
		return blogId;
	}
	public String getBlogComment() {
		return blogComment;
	}
	public String getBlogCommenterEmailId() {
		return blogCommenterEmailId;
	}
	public int getBlogCommentLikes() {
		return blogCommentLikes;
	}
	public String getBlogCommentStatus() {
		return blogCommentStatus;
	}
	public Date getBlogCommentDate() {
		return blogCommentDate;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	public void setBlogCommenterEmailId(String blogCommenterEmailId) {
		this.blogCommenterEmailId = blogCommenterEmailId;
	}
	public void setBlogCommentLikes(int blogCommentLikes) {
		this.blogCommentLikes = blogCommentLikes;
	}
	public void setBlogCommentStatus(String blogCommentStatus) {
		this.blogCommentStatus = blogCommentStatus;
	}
	public void setBlogCommentDate(Date blogCommentDate) {
		this.blogCommentDate = blogCommentDate;
	}
	
	
	
	
}
