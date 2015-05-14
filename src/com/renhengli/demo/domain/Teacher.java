package com.renhengli.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	private Long id;
	private String name;
	private String teachClassNo;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "teachClassNo")
	public String getTeachClassNo() {
		return teachClassNo;
	}

	public void setTeachClassNo(String teachClassNo) {
		this.teachClassNo = teachClassNo;
	}

}
