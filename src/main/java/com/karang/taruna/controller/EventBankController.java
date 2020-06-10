package com.karang.taruna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.karang.taruna.models.EventBank;
import com.karang.taruna.service.EventBankService;

@RestController
@RequestMapping("event-bank")
public class EventBankController {

	@Autowired
	EventBankService eventBankService;

	@GetMapping("{id}")
	public EventBank findById(@PathVariable String id) {
		return eventBankService.findById(id);
	}

	@GetMapping("/user/{id}/{idEvent}")
	public List<EventBank> findByIdUser(@PathVariable String id,@PathVariable String idEvent) {
		return eventBankService.findByIdUser(id, idEvent);
	}

	@PostMapping("")
	public EventBank createEventBank(@RequestBody EventBank eventBank) {
		return eventBankService.createEventBank(eventBank);
	}

	@GetMapping("")
	public List<EventBank> findAll() {
		return eventBankService.findAll();
	}

	@DeleteMapping("{id}/{idUser}")
	public void deleteById(@PathVariable String id, @PathVariable String idUser) {
		eventBankService.deleteById(id, idUser);
	}

}
