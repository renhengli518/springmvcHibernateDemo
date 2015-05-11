package com.renhengli.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.renhengli.demo.domain.Person;
import com.renhengli.demo.service.PersonService;

@Entity
@Controller
@RequestMapping(value = "/per")
// ¸ùÂ·¾¶
public class PersonController {
	@Resource
	private PersonService personService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(Person p) {
		personService.savePerson(p);
		return "redirect:/per/findAll";
	}

	@RequestMapping(value = "/findAll")
	public String findAllPersons(Model model) {
		List<Person> persons = personService.findAllPerson();
		model.addAttribute("persons", persons);
		return "personList";
	}

	@RequestMapping(value = "/addPersonUI")
	public String addPersonUI(Model model) {
		return "addPerson";
	}

	@RequestMapping(value = "/delete")
	public String delete(String id) {
		Person p = new Person();
		p.setId(id);
		personService.deletePerson(p);
		return "redirect:/per/findAll";
	}

	@RequestMapping(value = "/editUI")
	public String editUI(String id, Model model) {
		Person p = personService.findPersonById(id);
		model.addAttribute("p", p);
		return "editPerson";
	}

	@RequestMapping(value = "/update")
	public String updatePerson(Person p) {
		personService.updatePerson(p);
		return "redirect:/per/findAll";
	}
}
