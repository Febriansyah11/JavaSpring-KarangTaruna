package com.karang.taruna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karang.taruna.models.Event;
import com.karang.taruna.models.EventDetail;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetail, String> {
	List<EventDetail> findByStartDate(String startDate);
	List<EventDetail> findByType(String type);
	List<EventDetail> findByEvent(Event event);
	
}
