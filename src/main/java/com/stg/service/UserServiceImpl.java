package com.stg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.stg.entity.User;
import com.stg.exception.CustomException;
import com.stg.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) throws CustomException {
		User tempuser1 = userRepo.findByUserName(user.getUserName());
		User tempuser2 = userRepo.findByEmail(user.getEmail());

		if (tempuser1 != null) {
			throw new CustomException("Username already exists");
		}

		if (tempuser2 != null) {
			throw new CustomException("User Email already exists");
		}

		return userRepo.save(user);
	}

	@Override
	public User getUserByUserId(int userId) throws CustomException {

		Optional<User> optional = userRepo.findById(userId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException("No user with the given userId");
		}
	}

	@Override
	public List<User> getAllUsers() throws CustomException {

		return userRepo.findAll();
	}
	
	@Override
	public User updateUser(int userId, User newUser) throws CustomException {
		Optional<User> optional = userRepo.findById(userId);

		if (optional.isPresent()) {
			newUser.setUserId(userId);
		} else {
			throw new CustomException("UserId doesn't exists");
		}

		return userRepo.save(newUser);
	}
	

	@Override
	public User updateUserNameById(int userId, String userName) throws CustomException {
		User tempUser = null;
		Optional<User> optional = userRepo.findById(userId);

		if (optional.isPresent()) {
			tempUser = optional.get();
			tempUser.setUserName(userName);
		} else {
			throw new CustomException("UserId doesn't exists");
		}

		return userRepo.save(tempUser);
	}

	@Override	
	public User updatePasswordById(int userId, String password) throws CustomException {
		User tempUser = null;
		Optional<User> optional = userRepo.findById(userId);

		if (optional.isPresent()) {
			tempUser = optional.get();
			tempUser.setPassword(password);
		} else {
			throw new CustomException("UserId doesn't exists");
		}

		return userRepo.save(tempUser);
	}

	@Override
	public List<User> deleteUserById(int userId) throws CustomException {

		Optional<User> optional = userRepo.findById(userId);

		if (optional.isPresent()) {
			userRepo.deleteById(userId);
		} else {
			throw new CustomException("No user with the given userId");
		}

		return userRepo.findAll();
	}

	@Override
	public List<User> deleteUserByUserName(int userId, String userName) {
		User tempUser = null;
		Optional<User> optional = userRepo.findById(userId);

		if (optional.isPresent()) {
			tempUser = optional.get();
			if (tempUser.getUserName().equalsIgnoreCase(userName)) {
				userRepo.deleteByUserName(userName);
			} else {
				throw new CustomException("No userName with the given userId");
			}
		} else {
			throw new CustomException("No user with the given userId");
		}

		return userRepo.findAll();
	}

}
