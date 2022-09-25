package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;


@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll(){
		
		List<User> lst = repository.findAll();
		return lst;
	}
	
	// tratar exceção 	
	@GetMapping(value="/{id}")
	public User findById(@PathVariable Long id) {
		
		User user = repository.findById(id).get();
		return user;	
	}
	
	// tratar exceção
	@PostMapping
	public User insert(@RequestBody User user) {
		
		User u = repository.save(user);
		return u;
	}
	
}
