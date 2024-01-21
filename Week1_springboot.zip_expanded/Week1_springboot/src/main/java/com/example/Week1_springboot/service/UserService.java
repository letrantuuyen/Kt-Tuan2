package com.example.Week1_springboot.service;

import java.util.List;

import com.example.Week1_springboot.entity.User;

public interface UserService {
	
	public List<User> getAllUser();
	public User getUserById(Long id);
	public User addUser(User user);
	public void deleteUser(Long id);

}
