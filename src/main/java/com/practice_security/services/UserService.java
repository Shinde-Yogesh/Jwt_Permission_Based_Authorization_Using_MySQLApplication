package com.practice_security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice_security.entities.User;
import com.practice_security.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
	
	public User createUser(User user)
	{
		
		user.setUserId(UUID.randomUUID().toString());
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
		
	}

}
