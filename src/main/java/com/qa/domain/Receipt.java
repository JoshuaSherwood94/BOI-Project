package com.qa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Target;

@Entity
public class Receipt implements DomainEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(max=45)
	private String path;
	@Size(max=20000)
	private String text;
	@Size(max=45)
	private String location;
	
	public Receipt(){
		
	}
	public Receipt(String path, String text, String location) {
		this.path = path;
		this.text = text;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public String getText() {
		return text;
	}

	public String getLocation() {
		return location;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
