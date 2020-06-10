package com.karang.taruna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.exception.ExceptionResponse;
import com.karang.taruna.models.Admin;
import com.karang.taruna.models.Institution;
import com.karang.taruna.models.Users;
import com.karang.taruna.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public Admin findById(String id) {
		if (!adminRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Id Admin Not Found");
		} else {
			return adminRepository.findById(id).get();
		}
	}

	public Admin createAdmins(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin createAdmin(Admin admin, Institution institution) {
		System.out.println(institution + " id institution");
		admin.setInstitution(institution);
		return adminRepository.save(admin);
	}

	public Admin findByPhoneAdmin(String phoneNumber) {
		if (adminRepository.findByPhoneNumber(phoneNumber) == null) {
			throw new ExceptionNotFound("Admin Not Found");
		} else {
			return adminRepository.findByPhoneNumber(phoneNumber);
		}
	}

	public Admin findByEmail(String email) {
		if (adminRepository.findByEmail(email) != null) {
			throw new ExceptionResponse.EmailAddresAlreadyUsed();
		} else {
			throw new ExceptionResponse.RandomResponse("Accepted");
		}
	}

	public Admin updateAdmin(Admin admin, String idAdmin) {
		Admin updateAdmin = findById(idAdmin);
		if (admin.getAdminCode() != "") {
			updateAdmin.setAdminCode(admin.getAdminCode());
		}
		if (admin.getEmail() != "") {
			updateAdmin.setEmail(admin.getEmail());
		}
		if (admin.getName() != "") {
			updateAdmin.setName(admin.getName());
		}
		if (admin.getPhoneNumber() != "") {
			updateAdmin.setPhoneNumber(admin.getPhoneNumber());
		}
		return adminRepository.save(updateAdmin);
	}

	public void deleteById(String id) {
		Admin admin = findById(id);
		adminRepository.deleteById(admin.getId());
	}

}
