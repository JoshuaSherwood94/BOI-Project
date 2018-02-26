package com.qa.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Transaction implements DomainEntity{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id @Column(name="transaction_id")
	private Long transId;
	@Column(name="transaction_name") @Size(max=45)
	private String transName;
	@Column(name="date")
	private Calendar date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="transaction_id")
	@NotFound(action=NotFoundAction.IGNORE)
	Receipt receipt;
	
	public Transaction() {
		
	}

	public Transaction(String transName, Calendar date) {
		this.transName = transName;
		this.date = date;
	}

	public Long getTransId() {
		return transId;
	}

	public String getTransName() {
		return transName;
	}

	public Calendar getDate() {
		return date;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
}
