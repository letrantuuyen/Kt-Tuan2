package com.example.Week1_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Week1_springboot.entity.User;
import com.example.Week1_springboot.service.UserService;


@RestController
@RequestMapping("/home")
public class HomepageController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getProduct() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users");
		return userService.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public User userById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	
	@PostMapping("/add")
	public User addUser1( @RequestBody User user) {
		return userService.addUser(user);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "xoa thanh cong";
	}
	
	
	
}
