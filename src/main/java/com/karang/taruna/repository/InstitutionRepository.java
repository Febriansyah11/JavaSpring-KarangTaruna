package com.karang.taruna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.karang.taruna.models.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, String> {
	Institution findByInstitutionCode(String institutionCode);
}
