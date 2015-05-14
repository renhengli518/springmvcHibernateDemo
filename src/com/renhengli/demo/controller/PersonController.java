package com.renhengli.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.renhengli.demo.domain.Person;
import com.renhengli.demo.service.PersonService;

@Controller
@RequestMapping(value = "/per")
public class PersonController {
	private static Logger logger = Logger.getLogger(PersonController.class);
	private static org.slf4j.Logger logger2 = LoggerFactory
			.getLogger(PersonController.class);
	@Resource
	private PersonService personService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(Person p) throws UnsupportedEncodingException {
		logger.debug("logger start :--------------------------------");
		// String name = new String(p.getName().getBytes("iso8859-1"),"UTF-8");
		// String address = new
		// String(p.getAddress().getBytes("iso8859-1"),"UTF-8");
		// p.setName(name);
		// p.setAddress(address);
		personService.savePerson(p);
		logger.debug("logger end :--------------------------------");
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

	@RequestMapping(value = "/nameList")
	public String findByNames(Model model) {
		String[] name = new String[] { "张三", "任恒利" };
		List<Person> persons = personService.queryPersonListByNames(name);
		model.addAttribute("persons", persons);
		return "nameList";
	}
}
