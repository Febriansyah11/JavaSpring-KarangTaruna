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
import com.karang.taruna.models.EventDetail;
import com.karang.taruna.service.EventDetailService;

@RestController
@RequestMapping("event/details")
public class EventDetailController {

	@Autowired
	EventDetailService eventDetailService;

	@PostMapping("{idEvent}")
	public EventDetail createEventDetail(@RequestBody EventDetail eventDetail, @PathVariable String idEvent) {
		return eventDetailService.createEventDetail(eventDetail, idEvent);
	}

	@PutMapping("{idEventDetail}")
	public EventDetail updateEventDetail(@RequestBody EventDetail eventDetail, @PathVariable String idEventDetail) {
		return eventDetailService.updateEventDetail(eventDetail, idEventDetail);
	}

	@GetMapping("")
	public List<EventDetail> findAll() {
		return eventDetailService.findAll();
	}

	@DeleteMapping("{id}")	
	public void deleteById(@PathVariable String id) {
		eventDetailService.deleteById(id);
	}

	@GetMapping("{id}")
	public EventDetail findById(@PathVariable String id) {
		return eventDetailService.findById(id);
	}

	@GetMapping("/type/{type}")
	public List<EventDetail> findByType(@PathVariable String type) {
		return eventDetailService.findByType(type);
	}

}
