package com.stg.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public List<User> findAllByUserName(String userName);
	
	public User findByUserNameAndEmail(String userName, String email);

	public User findByUserName(String userName);

	public User findByEmail(String email);

	public void deleteByUserName(String userName);

}
