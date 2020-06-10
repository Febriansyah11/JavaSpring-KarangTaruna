package com.karang.taruna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karang.taruna.models.Admin;
import com.karang.taruna.service.AdminService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PutMapping("{idAdmin}")
	public Admin updateAdmin(@RequestBody Admin admin, @PathVariable String idAdmin) {
		return adminService.updateAdmin(admin, idAdmin);
	}

	@GetMapping("/phone/{phoneNumber}")
	public Admin findByPhoneAdmin(@PathVariable String phoneNumber) {
		return adminService.findByPhoneAdmin(phoneNumber);
	}

	@GetMapping("/email/{email}")
	public Admin findByEmail(@PathVariable String email) {
		return adminService.findByEmail(email);
	}

	@GetMapping("{id}")
	public Admin findById(@PathVariable String id) {
		return adminService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		adminService.deleteById(id);
	}

}
