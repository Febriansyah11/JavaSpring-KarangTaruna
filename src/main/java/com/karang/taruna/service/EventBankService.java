package com.karang.taruna.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.models.Event;
import com.karang.taruna.models.EventBank;
import com.karang.taruna.repository.EventBankRepository;
import com.karang.taruna.repository.EventRepository;

@Service
public class EventBankService {

	@Autowired
	EventBankRepository eventBankRepository;

	@Autowired
	EventService eventService;

	@Autowired
	EventRepository eventRepository;

	public EventBank findById(String id) {
		if (!eventBankRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Id Event bank service Not Found");
		} else {
			return eventBankRepository.findById(id).get();
		}
	}

	public List<EventBank> findByIdUser(String id, String idEvent) {
		List<EventBank> eventBanks = eventBankRepository.findByIdUser(id);
		List<EventBank> output = new ArrayList<>();
		for (EventBank eb : eventBanks) {
			if (eb.getEvent().contains(idEvent)) {
				output.add(eb);
			}
		}
		return output;
	}

	public EventBank createEventBank(EventBank eventBank) {
		BigDecimal bg = new BigDecimal(0);
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		Event event = eventService.findById(eventBank.getEvent());
		eventBank.setPaymentDate(ft.format(new Date(System.currentTimeMillis())));
		eventBank.setEvent(event);

		if (findByIdUser(eventBank.getIdUser(), event.getId()).isEmpty()) {
			eventBank.setTotal(new BigDecimal(0));
			eventBank.setTotal(eventBank.add(eventBank.getPay()));
		} else {
			for (EventBank eb : findByIdUser(eventBank.getIdUser(), event.getId())) {
				eb.setTotal(eb.getTotal().add(eventBank.getPay()));
				System.out.println(eb.toString());
				eventBankRepository.save(eb);
				if (bg.byteValue() == 0 ) {
					bg = eb.getTotal();
				}
			}
			eventBank.setTotal(bg);
		}
		eventBankRepository.save(eventBank);
		event.setMoneyOwned(event.getMoneyOwned().add(eventBank.getPay()));
		eventRepository.save(event);
		return eventBank;
	}

	public List<EventBank> findAll() {
		return eventBankRepository.findAll();
	}

	public void deleteById(String id, String idUser) {
		EventBank eventBank = findById(id);
		BigDecimal total = eventBank.getTotal();
		BigDecimal payed = eventBank.getPay();
		min(idUser, payed, total, eventBank.getEvent());
		eventBankRepository.deleteById(eventBank.getId());
		Event event = eventService.findById(eventBank.getEvent());
		event.setMoneyOwned(event.getMoneyOwned().subtract(eventBank.getPay()));
		eventService.save(event);
	}

	private void min(String idUser, BigDecimal payed, BigDecimal total, String idEvent) {
		BigDecimal temp = total.subtract(payed);
		for (EventBank eventBank2 : findByIdUser(idUser, idEvent)) {
			eventBank2.setTotal(temp);
			eventBankRepository.save(eventBank2);
		}
	}

}
