package com.karang.taruna.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.exception.ExceptionResponse;
import com.karang.taruna.models.Institution;
import com.karang.taruna.models.Users;
import com.karang.taruna.repository.UserRespository;

@Service
public class UserService {

	@Autowired
	UserRespository userRepository;

	@Autowired
	InstitutionService institutionService;

	@Autowired
	StatusService statusService;

	public List<Users> findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public Users createAdminUser(Users users, String idInstitution) {
		Set<Institution> institutions = new HashSet<>();
		Institution institution = institutionService.findById(idInstitution);
		institutions.add(institution);
		users.setInstitution(institutions);
		userRepository.save(users);
		statusService.createStatusAdmin(idInstitution, users);
		return users;
	}
	
	public Users save(Users users, String idInstitution) {
		Set<Institution> institutions = new HashSet<>();
		Institution institution = institutionService.findById(idInstitution);
		institutions.add(institution);
		users.setInstitution(institutions);
		userRepository.save(users);
		statusService.createStatus(idInstitution, users);
		return users;
	}

	public Users updateUsers(Users users, String idUser) {
		Users updateUsers = findById(idUser);
		if (users.getBirthDate() != null) {
			updateUsers.setBirthDate(users.getBirthDate());
		}
		if (users.getName() != "") {
			updateUsers.setName(users.getName());
		}
		if (users.getPassword() != "") {
			updateUsers.setPassword(users.getPassword());
		}
		if (users.getUsername() != "") {
			updateUsers.setUsername(users.getUsername());
		}
		return userRepository.save(updateUsers);
	}

	public List<Users> findAll() {
		return userRepository.findAll();
	}

	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	public Users findByUsername(String username) {
		if (userRepository.findByUsername(username) != null) {
			throw new ExceptionResponse.PhoneNumberAlreadyUsed();
		} else {
			throw new ExceptionResponse.RandomResponse("Accepted");
		}
	}

	public Users findById(String id) {
		if (!userRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Id User Not Found");
		} else {
			return userRepository.findById(id).get();
		}
	}

	public Users updateStatus(String status, String idUser) {
		Users user = findById(idUser);
		System.out.println(user.toString() + " ini user nya");
		System.out.println(status + " ini status nya");

		return userRepository.save(user);
	}
}
