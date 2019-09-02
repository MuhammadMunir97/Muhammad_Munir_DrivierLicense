package com.muhammad.driverlicense.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.driverlicense.modell.Person;
import com.muhammad.driverlicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAll (){
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
			return person.get();
		}else {
			return null;
		}
	}
	
	public List<Person> findAllWithNoLicense(){
		List<Person> person = personRepository.findAll();
		for(int i = 0; i < person.size(); i++) {
			boolean doesPersonHaveLicense = (person.get(i).getLicense() != null);
			if(doesPersonHaveLicense) {
				person.remove(i);
				i--;
			}
		}
		return person;
	}
	
	public void savePerson(Person person) {
		personRepository.save(person);
	}
	
	public void deletePersonById(Long id) {
		personRepository.deleteById(id);;
	}

	
}
