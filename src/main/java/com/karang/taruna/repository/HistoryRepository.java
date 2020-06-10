package com.karang.taruna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karang.taruna.models.WithdrawalHistory;

@Repository
public interface HistoryRepository extends JpaRepository<WithdrawalHistory, String> {
	List<WithdrawalHistory> findByEvent(String event);
}
