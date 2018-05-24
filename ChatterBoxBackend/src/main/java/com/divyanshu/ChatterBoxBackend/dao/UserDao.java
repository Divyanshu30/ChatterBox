package com.divyanshu.ChatterBoxBackend.dao;

import java.util.List;

import com.divyanshu.ChatterBoxBackend.model.User;


public interface UserDao {
	
User getUserByUserName(String user);
boolean validUser(User user);
boolean addUser(User User);
boolean deleteUser(int userId);
boolean editUser(User user);
User getUserbyUserId(int userId);
List<User> getAllUsers();
	
}
