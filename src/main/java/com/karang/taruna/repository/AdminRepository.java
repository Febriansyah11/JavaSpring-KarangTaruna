package com.karang.taruna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.karang.taruna.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	Admin findByEmail(String email);
	Admin findByPhoneNumber(String phoneNumber);
}