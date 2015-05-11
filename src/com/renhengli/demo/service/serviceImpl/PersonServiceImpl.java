package com.renhengli.demo.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.renhengli.demo.dao.PersonDao;
import com.renhengli.demo.entity.Person;
import com.renhengli.demo.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Resource
	private PersonDao personDao;

	public void deletePerson(Person p) {
		personDao.deletePerson(p);
	}

	public List<Person> findAllPerson() {
		return personDao.findAllPerson();
	}

	public Person findPersonById(String id) {
		return personDao.findPersonById(id);
	}

	public void savePerson(Person p) {
		personDao.savePerson(p);
	}

	public void updatePerson(Person p) {
		personDao.updatePerson(p);
	}

}
