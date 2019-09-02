package com.muhammad.driverlicense.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muhammad.driverlicense.modell.License;
import com.muhammad.driverlicense.modell.Person;
import com.muhammad.driverlicense.service.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;

	public PersonController(PersonService personService ) {
		this.personService = personService;
	}
	
	@RequestMapping("/person")
	public String allPerson(Model model) {
		List<Person> allPerson = personService.findAll();
		model.addAttribute("people" , allPerson);
		return "/view/Person.jsp";
	}
	
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/view/NewPerson.jsp";
	}
	
	@RequestMapping(value="/person" , method=RequestMethod.POST)
	public String addPerson(@Valid @ModelAttribute("person") Person person , BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "redirect:/person";
        } else {
        	personService.savePerson(person);
            return "redirect:/person";
        }
	}
	
	@RequestMapping(value="/person/{id}" , method=RequestMethod.DELETE)
	public String deletePerson(@PathVariable("id") Long id) {
		personService.deletePersonById(id);
		return "redirect:/person";
	}
	
	@RequestMapping("/person/license")
	public String newLicense(Model model, @ModelAttribute("license") License license ) {
		List<Person> allPerson = personService.findAllWithNoLicense();
		model.addAttribute("people" , allPerson);
		return "/view/NewLicense.jsp";
	}
	
	@RequestMapping("/person/{id}")
	public String showPersonInfo(Model model, @PathVariable("id") Long id) {
		Person currentPerson = personService.findById(id);
		model.addAttribute("person" , currentPerson);
		return "/view/ShowPerson.jsp";
	}
	
	@RequestMapping(value="/person/license" , method=RequestMethod.POST)
	public String addLicenseToPerson(@Valid @ModelAttribute("license") License license , BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			return "redirect:/person";
        } else {
        	Long id = license.getPerson().getId();
        	Person currentPerson = personService.findById(id);
        	license.setNumber(license.getPerson().getId());
        	if (currentPerson.getLicense() == null) {
        		currentPerson.setLicense(license);
            	personService.savePerson(currentPerson);
        	}
            return "redirect:/person";
        }
	}
}
