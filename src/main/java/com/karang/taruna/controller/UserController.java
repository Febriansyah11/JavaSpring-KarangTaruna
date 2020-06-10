package com.karang.taruna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.karang.taruna.models.Users;
import com.karang.taruna.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("name/{name}")
	public List<Users> findByName(@PathVariable String name) {
		return userService.findByName(name);
	}

	@PostMapping("{idInstitution}")	
	public Users save(@RequestBody Users user, @PathVariable String idInstitution) {
		return userService.save(user, idInstitution);
	}

	@PostMapping("/admin/{idInstitution}")
	public Users createAdminUser(@RequestBody Users user, @PathVariable String idInstitution) {
		return userService.createAdminUser(user, idInstitution);
	}

	@GetMapping("")
	public List<Users> findAll() {
		return userService.findAll();
	}

	@GetMapping("{id}")
	public Users findById(@PathVariable String id) {
		return userService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		userService.deleteById(id);
	}

	@GetMapping("/phone/{phoneNumber}")
	public Users findByPhoneNumber(@PathVariable String phoneNumber) {
		return userService.findByUsername(phoneNumber);
	}

	@PutMapping("{idUser}")
	public Users updateUsers(@RequestBody Users users, @PathVariable String idUser) {
		return userService.updateUsers(users, idUser);
	}

}
