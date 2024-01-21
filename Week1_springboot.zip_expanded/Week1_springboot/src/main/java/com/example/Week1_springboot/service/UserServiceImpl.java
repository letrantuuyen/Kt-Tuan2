package com.example.Week1_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Week1_springboot.entity.User;
import com.example.Week1_springboot.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);		
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
		
	}

	
	
	

}
