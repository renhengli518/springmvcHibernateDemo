package com.renhengli.demo.service;

import java.util.List;

import com.renhengli.demo.domain.Person;

public interface PersonService {
	public void savePerson(Person p);

	public void deletePerson(Person p);

	public void updatePerson(Person p);

	public List<Person> findAllPerson();

	public Person findPersonById(String id);

}
