package com.karang.taruna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karang.taruna.models.EventBank;

@Repository
public interface EventBankRepository extends JpaRepository<EventBank, String> {
	List<EventBank> findByIdUser(String idUser);
	List<EventBank> findByEvent(String event);
}