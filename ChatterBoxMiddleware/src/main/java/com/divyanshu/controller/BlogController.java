package com.divyanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divyanshu.ChatterBoxBackend.dao.BlogDao;
import com.divyanshu.ChatterBoxBackend.model.Blog;

@RestController
//@CrossOrigin(origins="http://localhost:4200" , allowedHeaders="*")
@RequestMapping(value = "api")
public class BlogController {
	@Autowired
	private Blog blog;
	@Autowired
	private BlogDao blogDao;
	
	@GetMapping(value = "/allBlogs")
	public ResponseEntity<List<Blog>> getAllBlogs(@RequestParam("id") String id) {
		return new ResponseEntity<List<Blog>>(blogDao.getAllBlog(id), HttpStatus.OK);
	}

	
	
}
