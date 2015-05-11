package com.renhengli.demo.dao.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.renhengli.demo.dao.PersonDao;
import com.renhengli.demo.entity.Person;

public class PersonDaoImpl implements PersonDao {
	private HibernateTemplate hibernateTemplate;

	public PersonDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Resource(name = "sf")
	private SessionFactory sf;

	public void deletePerson(Person p) {
		sf.getCurrentSession().delete(p);
	}

	public List<Person> findAllPerson() {
		return sf.getCurrentSession().createQuery("from Person").list();
	}

	public Person findPersonById(String id) {
		return (Person) sf.getCurrentSession().get(Person.class, id);
	}

	public void savePerson(Person p) {
		sf.getCurrentSession().save(p);
	}

	public void updatePerson(Person p) {
		sf.getCurrentSession().update(p);
	}
}
