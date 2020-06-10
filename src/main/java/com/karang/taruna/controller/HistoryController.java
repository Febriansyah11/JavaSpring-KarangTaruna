package com.karang.taruna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.karang.taruna.models.WithdrawalHistory;
import com.karang.taruna.service.HistoryService;

@RestController
@RequestMapping("event-history")
public class HistoryController {

	@Autowired
	HistoryService historyService;
	
	@PostMapping("")
	public WithdrawalHistory save(@RequestBody WithdrawalHistory withdrawalHistory) {
		return historyService.save(withdrawalHistory);
	}

	@GetMapping("{idEvent}")
	public List<WithdrawalHistory> findByEvent(@PathVariable String idEvent) {
		return historyService.findByEvent(idEvent);
	}
	
	@GetMapping("id/{id}")
	public Optional<WithdrawalHistory> findById(@PathVariable String id) {
		return historyService.findById(id);
	}
	
	
}
