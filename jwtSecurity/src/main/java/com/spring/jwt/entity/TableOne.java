package com.spring.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableOne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TableOne(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TableOne() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TableOne [id=" + id + ", name=" + name + "]";
	}
	
	
}
