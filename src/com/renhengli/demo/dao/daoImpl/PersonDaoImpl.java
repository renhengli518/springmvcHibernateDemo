package com.renhengli.demo.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renhengli.demo.dao.PersonDao;
import com.renhengli.demo.domain.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
	// private HibernateTemplate hibernateTemplate;
	//
	// public PersonDaoImpl(HibernateTemplate hibernateTemplate) {
	// this.hibernateTemplate = hibernateTemplate;
	// }
//	@PersistenceContext
//	private EntityManager entityManger;
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Resource(name = "sessionFactory")
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

	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void savePerson(Person p) {
		sf.getCurrentSession().save(p);
	}

	public void updatePerson(Person p) {
		sf.getCurrentSession().update(p);
	}

	@SuppressWarnings("unchecked")
	public List<Person> queryPersonListByNames(String name) {
		StringBuffer sb = new StringBuffer();
//		sb.append("from Person where name in (");
//		for (int i = 0; i < name.length; i++) {
//			sb.append("'" + name[i] + "'");
//			if (i < name.length - 1) {
//				sb.append(",");
//			}
//		}
//		sb.append(")");
		// return null;
		sb.append("from Person where name ='").append(name).append("'");
		List<Person> list=  new ArrayList<Person>();
		try {
			list = hibernateTemplate.find(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public List<Person> getListOfPerson(int page,int pagesize){
		Query query = sf.getCurrentSession().createQuery("from Person");
		query.setFirstResult((page-1)*pagesize);
		query.setMaxResults(pagesize);
		List<Person> list = query.list();
		return list;
	}
}
