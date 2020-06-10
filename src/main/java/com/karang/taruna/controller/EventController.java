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

import com.karang.taruna.models.Event;
import com.karang.taruna.service.EventService;

@RestController
@RequestMapping("events")
public class EventController {

	@Autowired
	EventService eventservice;

	@GetMapping("")
	public List<Event> findAll() {
		return eventservice.findAll();
	}

	@GetMapping("institution/{idInstitution}")
	public List<Event> findByIdInstitution(@PathVariable String idInstitution) {
		return eventservice.findByIdInstitution(idInstitution);
	}

	@GetMapping("{id}")
	public Event findById(@PathVariable String id) {
		return eventservice.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteEventById(@PathVariable String id) {
		eventservice.deleteEventById(id);
	}

	@PostMapping("{idInstitution}")
	public Event createEvent(@RequestBody Event event, @PathVariable String idInstitution) {
		return eventservice.createEvent(event, idInstitution);
	}

	@PutMapping("{id}")
	public Event updateEvent(@RequestBody Event event, @PathVariable String id) {
		return eventservice.updateEvent(event, id);
	}

}
