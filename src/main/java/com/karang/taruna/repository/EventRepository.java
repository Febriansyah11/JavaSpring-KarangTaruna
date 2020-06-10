package com.karang.taruna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.karang.taruna.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
	List<Event> findByIdInstitution(String idInstitution);
}