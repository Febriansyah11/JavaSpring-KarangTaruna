package com.karang.taruna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.karang.taruna.models.Institution;
import com.karang.taruna.service.InstitutionService;

@RestController
@RequestMapping("institution")
public class InstitutionController {

	@Autowired
	InstitutionService institutionService;

	@GetMapping("{id}")
	public Institution findById(@PathVariable String id) {
		return institutionService.findById(id);
	}

	@GetMapping("")
	public List<Institution> findAll() {
		return institutionService.findAll();
	}
	
	@GetMapping("/referal/{code}")
	public Institution findByInstitutionCode(@PathVariable String code) {
		return institutionService.findByInstitutionCode(code);
	}

	@PostMapping("")
	public Institution createAdmin(@RequestBody Institution institution) {
		return institutionService.createInstitution(institution);
	}

}
