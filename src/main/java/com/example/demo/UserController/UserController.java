package com.example.demo.UserController;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserEntity.UserEntity;
import com.example.demo.UserService.UserService;


@RestController
public class UserController {
	

	@Autowired
	private UserService us;
	@GetMapping("/get")
	public List<UserEntity> getAllUsers() {
	return us.getAllUsers();
	}
	@GetMapping("/get/{id}")
	public Optional<UserEntity> getUserById(@PathVariable int id) {
	return us.getUserById(id);
	}
	@PostMapping("/insert")
	public List<UserEntity> createUser(@RequestBody List<UserEntity> user) {
	return us.createUser(user);
	}
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable int id, @RequestBody UserEntity userDetails) {
	us.updateUser(id, userDetails);
	return "User Updated";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
	us.deleteUser(id);
	return "Deleted User";
	}
	}
