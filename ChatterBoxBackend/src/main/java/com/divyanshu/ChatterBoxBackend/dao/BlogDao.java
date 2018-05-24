package com.divyanshu.ChatterBoxBackend.dao;

import java.util.List;

import com.divyanshu.ChatterBoxBackend.model.Blog;

public interface BlogDao {
	Blog getBlogById(int blogId);
	Blog getBlogByName(String blogName);
	boolean addBlog(Blog blog);
	boolean deleteBlog(int blogId);
	boolean updateBlog(Blog blog);
	boolean updateLikes(int blogId);
	List<Blog>getAllBlog(String UserId);

}
