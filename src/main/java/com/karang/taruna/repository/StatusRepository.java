package com.karang.taruna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karang.taruna.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, String> {}
