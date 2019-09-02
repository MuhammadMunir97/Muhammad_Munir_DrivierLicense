package com.muhammad.driverlicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muhammad.driverlicense.modell.License;



public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
}
