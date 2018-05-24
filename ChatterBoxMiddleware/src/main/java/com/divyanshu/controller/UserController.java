package com.divyanshu.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.divyanshu.ChatterBoxBackend.dao.UserDao;
import com.divyanshu.ChatterBoxBackend.model.User;

@RestController
@CrossOrigin(origins="http://localhost:4200" , allowedHeaders="*")
@RequestMapping(value="api/user")
public class UserController {

		@Autowired
		UserDao userDao;
		
     @GetMapping(value= "allUser")
     @ResponseBody
     public ResponseEntity<List<User>> getallUser() {
	 List<User> allUsers = userDao.getAllUsers();
     return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		}
     @GetMapping(value= "user/{id}")
     @ResponseBody
     public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
	 User user = userDao.getUserbyUserId(userId);
     return new ResponseEntity<User>(user, HttpStatus.OK);
		}
     @GetMapping(value= "user/{name}")
     @ResponseBody
     public ResponseEntity<User> getUserByName(@PathVariable("name") String userName) {
	 User user = userDao.getUserByUserName(userName);
     return new ResponseEntity<User>(user, HttpStatus.OK);
		}
     @PutMapping(value= "deleteuser/{id}")
     @ResponseBody
     public ResponseEntity deleteUser(@PathVariable("id") int userId) {
	 userDao.deleteUser(userId);
     return new ResponseEntity(HttpStatus.ACCEPTED);
		}
     
     
		
	}

