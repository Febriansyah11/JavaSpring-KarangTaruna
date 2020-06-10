package com.karang.taruna.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.exception.ExceptionResponse;
import com.karang.taruna.models.Event;
import com.karang.taruna.models.Institution;
import com.karang.taruna.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	InstitutionService institutionService;

	public Event findById(String id) {
		if (!eventRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Event Not Found");
		} else {
			return eventRepository.findById(id).get();
		}
	}

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	public List<Event> findByIdInstitution(String idInstitution) {
		return eventRepository.findByIdInstitution(idInstitution);
	}

	public Event createEvent(Event event, String idInstitution) {
		Institution institution = institutionService.findById(idInstitution);
		event.setMoneyOwned(new BigDecimal(0));
		event.setIdInstitution(idInstitution);
		event.setInstitution(institution);
		if (event.getEndDate() == null)
			event.setEndDate(event.getStartDate());
		for (Event allEvent : findByIdInstitution(idInstitution)) {
			if (event.getValdate() == "") {
				String idA = allEvent.getIdInstitution();
				String eventStart = event.getStartDate().toString();
				String eventEnd = event.getEndDate().toString();
				String startEvent = allEvent.getStartDate().toString();
				String endEvent = allEvent.getEndDate().toString();
				validateDate(event, idInstitution, allEvent, idA, eventStart, eventEnd, startEvent, endEvent);
			}
		}
		return eventRepository.save(event);
	}

	private void validateDate(Event event, String idInstitution, Event allEvent, String idA, String eventStart,
			String eventEnd, String startEvent, String endEvent) {
		if (idA.contains(idInstitution)) {
			if (eventEnd.contains(endEvent) || eventStart.contains(startEvent))
				throw new ExceptionResponse.ExceptionDateAlreadyUsed();
			boolean hasil = validationDate(allEvent.getStartDate(), allEvent.getEndDate(), event.getStartDate(),
					event.getEndDate());
			System.out.println(hasil + "hasil");
			if (hasil == true)
				throw new ExceptionResponse.ExceptionDateAlreadyUsed();
		}
	}

	public static boolean validationDate(final Date min, final Date max, final Date start, final Date end) {
		return !(start.before(min) || start.after(max));
	}

	public Event updateEvent(Event event, String id) {
		Event updatEvent = findById(id);
		if (event.getStartDate() != null) {
			if (event.getEndDate() == null) event.setEndDate(event.getStartDate());
			for	 (Event allEvent : findByIdInstitution(updatEvent.getInstitution())) {
				if (event.getValdate() == "") {
					String idA = allEvent.getIdInstitution();
					String eventStart = event.getStartDate().toString();
					String eventEnd = event.getEndDate().toString();
					String startEvent = allEvent.getStartDate().toString();
					String endEvent = allEvent.getEndDate().toString();
					validateDate(event, updatEvent.getIdInstitution(), allEvent, idA, eventStart, eventEnd, startEvent, endEvent);
				}
			}
		}
		if (event.getEndDate() != null) {
			updatEvent.setEndDate(event.getEndDate());
		}
		if (event.getPurpose() != "") {
			updatEvent.setPurpose(event.getPurpose());
		}
		if (event.getStartDate() != null) {
			updatEvent.setStartDate(event.getStartDate());
		}
		if (event.getTittle() != "") {
			updatEvent.setTittle(event.getTittle());
		}
		if (event.getTittle() != "") {
			updatEvent.setTittle(event.getTittle());
		}
		if (event.getMoneyOwned() != null) {
			updatEvent.setMoneyOwned(event.getMoneyOwned());
		}
		return eventRepository.save(updatEvent);
	}
	
	
	public void save(Event event) {
		eventRepository.save(event);
	}
	
	
	public void deleteEventById(String id) {
		Event event = findById(id);
		eventRepository.deleteById(event.getId());
	}

}
