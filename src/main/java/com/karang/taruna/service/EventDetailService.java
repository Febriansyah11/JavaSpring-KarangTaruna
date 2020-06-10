package com.karang.taruna.service;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karang.taruna.constant.DetailEvent;
import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.exception.ExceptionResponse;
import com.karang.taruna.models.Event;
import com.karang.taruna.models.EventDetail;
import com.karang.taruna.repository.EventDetailRepository;

@Service
public class EventDetailService {

	@Autowired
	EventDetailRepository eventDetailRepository;

	@Autowired
	EventService eventService;

	public EventDetail createEventDetail(EventDetail eventDetail, String idEvent) {
		EventDetail newEventDetail = new EventDetail();
		Event event = eventService.findById(idEvent);
		newEventDetail.setEventName(eventDetail.getEventName());
		newEventDetail.setEvent(event);
		newEventDetail.setMc(eventDetail.getMc());
		if (eventDetail.getType().contains("1")) {
			newEventDetail.setType(DetailEvent.PREPARATION);
		} else {
			String aString = eventDetail.getStartDate().substring(0, 10);
			Date startDate = Date.valueOf(aString);
			boolean temp = validationStartDateEvent(event.getStartDate(), event.getEndDate(), startDate);
			if (temp == false)
				throw new ExceptionResponse.DateOutOfASchedule();
			newEventDetail.setType(DetailEvent.IMPLEMENTATION);
		}
		newEventDetail.setStartDate(eventDetail.getStartDate());
		return eventDetailRepository.save(newEventDetail);
	}

	public static boolean validationStartDateEvent(final Date min, final Date max, final Date start) {
		return !(start.before(min) || start.after(max));
	}

	public EventDetail updateEventDetail(EventDetail eventDetail, String idEventDetail) {
		EventDetail updateDetail = findById(idEventDetail);
		if (eventDetail.getStartDate() != "") {
			if (updateDetail.getType().contains("Implementation")) {
				String aString = eventDetail.getStartDate().substring(0, 10);
				Date startDate = Date.valueOf(aString);
				Date start = updateDetail.getEvent().getStartDate();
				Date end = updateDetail.getEvent().getEndDate();
				boolean temp = validationStartDateEvent(start, end, startDate);
				if (temp == false) throw new ExceptionResponse.DateOutOfASchedule();
			}
			updateDetail.setStartDate(eventDetail.getStartDate());
		}
		if (eventDetail.getMc() != "") updateDetail.setMc(eventDetail.getMc());
		if (eventDetail.getEventName() != "") updateDetail.setEventName(eventDetail.getEventName());
		return eventDetailRepository.save(updateDetail);
	}

	public List<EventDetail> findAll() {
		return eventDetailRepository.findAll();
	}

	public void deleteById(String id) {
		EventDetail eventDetail = findById(id);
		eventDetailRepository.deleteById(eventDetail.getId());
	}

	public EventDetail findById(String id) {
		if (!eventDetailRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Event Detail Not Found");
		} else {
			return eventDetailRepository.findById(id).get();
		}
	}

	public List<EventDetail> findByStartDate(String startDate) {
		return eventDetailRepository.findByStartDate(startDate);
	}

	public List<EventDetail> findByType(String type) {
		String findType = "";
		if (type.contains("1"))	findType = "Preparation";
		if (type.contains("2")) findType = "Implementation";
		return eventDetailRepository.findByType(findType);
	}
}
