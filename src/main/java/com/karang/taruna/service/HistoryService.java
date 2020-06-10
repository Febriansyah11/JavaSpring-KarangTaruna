package com.karang.taruna.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karang.taruna.models.Event;
import com.karang.taruna.models.EventBank;
import com.karang.taruna.models.WithdrawalHistory;
import com.karang.taruna.repository.EventRepository;
import com.karang.taruna.repository.HistoryRepository;

@Service
public class HistoryService {

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	EventService eventService;

	@Autowired
	EventRepository eventRepository;

	public WithdrawalHistory save(WithdrawalHistory withdrawalHistory) {
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		Event event = eventService.findById(withdrawalHistory.getEvent());
		withdrawalHistory.setEvent(event);
		withdrawalHistory.setDate(ft.format(new Date(System.currentTimeMillis())));
		historyRepository.save(withdrawalHistory);
		event.subtract(withdrawalHistory.getMoneys());
		eventRepository.save(event);
		return withdrawalHistory;
	}

	public List<WithdrawalHistory> findByEvent(String event) {
		Event event2 = eventService.findById(event);
		return historyRepository.findByEvent(event2.getId());
	}

	public Optional<WithdrawalHistory> findById(String id) {
		return historyRepository.findById(id);
	}

	public void deleteAll() {
		historyRepository.deleteAll();
	}

}
