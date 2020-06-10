package com.karang.taruna.service;

import java.security.SecureRandom;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.karang.taruna.exception.ExceptionNotFound;
import com.karang.taruna.models.Institution;
import com.karang.taruna.repository.InstitutionRepository;

@Service
public class InstitutionService {

	@Autowired
	InstitutionRepository institutionRepository;

	@Autowired
	AdminService adminService;

	public Institution findById(String id) {
		if (!institutionRepository.findById(id).isPresent()) {
			throw new ExceptionNotFound("Id Institution Not Found");
		} else {
			return institutionRepository.findById(id).get();
		}
	}

	public List<Institution> findAll() {
		return institutionRepository.findAll();
	}

	public Institution findByInstitutionCode(String institutionCode) {
		if (institutionRepository.findById(institutionCode).isPresent()) {
			throw new ExceptionNotFound("Id Institution Not Found");
		} else {
			return institutionRepository.findByInstitutionCode(institutionCode);
		}
	}

	public String createRandomCode() {
		int codeLength = 5;
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXY1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new SecureRandom();
		for (int i = 0; i < codeLength; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	public Institution createInstitution(Institution institution) {
		Date date = new Date((System.currentTimeMillis()));
		SimpleDateFormat ft = new SimpleDateFormat("Md");
		SimpleDateFormat ft1 = new SimpleDateFormat("ms");
		String referalCode = ft.format(date) + createRandomCode() + ft1.format(date);
		Institution newInstitution = new Institution();
		newInstitution.setInstitutionCode(referalCode);
		newInstitution.setInstitutionName(institution.getInstitutionName());
		newInstitution.setRtNumber(institution.getRtNumber());
		newInstitution.setRwNumber(institution.getRwNumber());
		newInstitution.setDesa(institution.getDesa());
		newInstitution.setKecamatan(institution.getKecamatan());
		newInstitution.setKabupatenKota(institution.getKabupatenKota());
		newInstitution.setProvinsi(institution.getProvinsi());
		newInstitution.setPostalCode(institution.getPostalCode());
		newInstitution.setAlamat(institution.getAlamat());
		newInstitution.setCreatedDate(new Date(System.currentTimeMillis()));
		Institution save = institutionRepository.save(newInstitution);
		adminService.createAdmin(institution.getAdmin(), save);
		return findById(save.getId());
	}

	public Institution updateInstitution(Institution institution, String idInstitution) {
		Institution updateInstitution = findById(idInstitution);
		return institutionRepository.save(institution);
	}

}
