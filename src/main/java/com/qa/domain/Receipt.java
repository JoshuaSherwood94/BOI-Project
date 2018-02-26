package com.qa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

public class Receipt implements DomainEntity{
	@Id
	@Column(name="Receipt_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(max=45)
	private String path;
	@Size(max=20000)
	private String text;
	@Size(max=45)
	private String location;

	private Transaction transaction;
	
	public Receipt(String path, String text, String location, Transaction transaction) {
		this.path = path;
		this.text = text;
		this.location = location;
		this.transaction = transaction;
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

	public Transaction getTransaction() {
		return transaction;
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

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
