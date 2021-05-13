package com.furkancelik.deneme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String company;
	private String position;
	private String city;
	
	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	private Date finish_date;
	
	private int userID;

	public Experience() {
	}

	public Experience(int id, String company, String position, String city, Date start_date, Date finish_date,
			int userID) {
		this.id = id;
		this.company = company;
		this.position = position;
		this.city = city;
		this.start_date = start_date;
		this.finish_date = finish_date;
		this.userID = userID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	
	
	
}
