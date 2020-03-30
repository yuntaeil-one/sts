package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users")
	public List<User> userlist() {
		List<User> list = userRepository.findAll();
		return list;
	}
	
	@RequestMapping(value = "/users/{id}")
	public User getUser(@PathVariable("id") Long id) {
		User user = userRepository.findByIdLike(id);
		return user;
	}
	
	@RequestMapping(value = "/users/{age}/{name}")
	public List<User> saveUser(@PathVariable("age") int age, @PathVariable("name") String name) {
		
		User user = new User(age, name);
		userRepository.save(user);
		
		List<User> list = userRepository.findAll();
		
		return list;
	}
			

}
