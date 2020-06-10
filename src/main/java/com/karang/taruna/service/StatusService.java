package com.karang.taruna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.models.Status;
import com.karang.taruna.models.Users;
import com.karang.taruna.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	StatusRepository statusRepository;

	public Status findById(String id) {
		if (!statusRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Id Status Not Found");
		} else {
			return statusRepository.findById(id).get();
		}
	}

	public Status createStatus(String idInstitution, Users users) {
		Status status = new Status(idInstitution, "USER", users);
		return statusRepository.save(status);
	}
	
	public Status createStatusAdmin(String idInstitution, Users users) {
		Status status = new Status(idInstitution, "ADMIN", users);
		return statusRepository.save(status);
	}

	public Status updateStatus(Status status,String idStatus) {
		Status updateStatus = findById(idStatus);
		updateStatus.setStatus(status.getStatus());
		return statusRepository.save(updateStatus);
	}

	public List<Status> findAll() {
		return statusRepository.findAll();
	}

}
