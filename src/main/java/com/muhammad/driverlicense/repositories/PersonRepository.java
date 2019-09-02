package com.muhammad.driverlicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muhammad.driverlicense.modell.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
