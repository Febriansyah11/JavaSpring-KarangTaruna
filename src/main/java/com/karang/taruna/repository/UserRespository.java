package com.karang.taruna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karang.taruna.models.Users;

@Repository
public interface UserRespository extends JpaRepository<Users, String> {
	List<Users> findByName(String name);
	Users findByUsername(String username);
}
