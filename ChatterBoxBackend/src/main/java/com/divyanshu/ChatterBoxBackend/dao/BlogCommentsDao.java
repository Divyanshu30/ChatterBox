package com.divyanshu.ChatterBoxBackend.dao;

import java.util.List;

import com.divyanshu.ChatterBoxBackend.model.BlogComments;

public interface BlogCommentsDao {

boolean addBlogComment(BlogComments blogComments); 	
boolean deleteBlogComment(int blogCommentId);
BlogComments getBlogCommentById(int blogCommentId);
List<BlogComments> getAllComments(int blogComments);
boolean editBlogComment(BlogComments blogComments);
boolean updateBlogCommentLikes(int blogCommentId);
}
