package com.renhengli.demo.dao;

import java.util.List;

import com.renhengli.demo.domain.Person;

public interface PersonDao {
		public void savePerson(Person p);
		public void deletePerson(Person p);
		public void updatePerson(Person p);
		public List<Person> findAllPerson();
		public Person findPersonById(String id);
		public List<Person> queryPersonListByNames(String name);
		public List<Person> getListOfPerson(int page,int pagesize);
		}

		
