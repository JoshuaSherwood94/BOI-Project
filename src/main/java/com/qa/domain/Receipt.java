package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Target;

@Entity
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

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="transaction_id")
	@Target(Transaction.class)
	private long transactionID;
	
	public Receipt(String path, String text, String location, long transaction) {
		this.path = path;
		this.text = text;
		this.location = location;
		this.transactionID = transaction;
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

	public long getTransactionID() {
		return transactionID;
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

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
}
