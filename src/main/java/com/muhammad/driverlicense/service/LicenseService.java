package com.muhammad.driverlicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.driverlicense.modell.License;
import com.muhammad.driverlicense.repositories.LicenseRepository;

@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> findAll(){
		return licenseRepository.findAll();
	}
	
	public License findById(Long id) {
		Optional<License> license = licenseRepository.findById(id);
		if(license.isPresent()) {
			return license.get();
		}else {
			return null;
		}
	}
	
	public void saveLicense(License license) {
		licenseRepository.save(license);
	}
	
	public void deleteLicenseById(Long id) {
		licenseRepository.deleteById(id);
	}
	
}
