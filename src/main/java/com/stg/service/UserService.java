package com.stg.service;

import java.util.List;

import com.stg.entity.User;

public interface UserService {
	public abstract User createUser(User user);

	public abstract User getUserByUserId(int userId);

	public abstract List<User> getAllUsers();
	
	public abstract User updateUser(int userId, User newUser);
	
	public abstract User updateUserNameById(int userId, String userName);

	public abstract User updatePasswordById(int userId, String password);

	public abstract List<User> deleteUserById(int userId);
	
	public abstract List<User> deleteUserByUserName(int userId, String userName);

}
