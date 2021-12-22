package com.knowledgepioneer.records.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Records is a JPA entity class. This has the ability to represent objects in the database.
 * 
 * */


@Entity
@Table(name="records")
public class Records {
	
	//define fields
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="year")
	private String year;
	
	@Column(name="country")
	private String country;
	
	@Column(name="abstract")
	private String absract;
	
	//define constructors
	public Records(){}

	public Records(String title, String year, String country, String absract) {
		this.title = title;
		this.year = year;
		this.country = country;
		this.absract = absract;
	}


	//getter and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getAbsract() {
		return absract;
	}

	public void setAbsract(String absract) {
		this.absract = absract;
	}


	//toString
	@Override
	public String toString() {
		return "Records [id=" + id + ", title=" + title + ", year=" + year + ", country=" + country
				+ ", absract=" + absract + "]";
	}
	
	
	
	
}
