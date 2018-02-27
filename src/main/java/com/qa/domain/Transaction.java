package com.qa.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@Column(name="date")@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="amount")
	private Double amount;
	
	//@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JoinColumn(name="transaction_id")
	//@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="transaction_id")
	private Set<Receipt> receipts = new HashSet<Receipt>();
	
	public Transaction() {
		
	}

	public Transaction(String transName, Date date, double amount) {
		this.transName = transName;
		this.date = date;
		this.amount = amount;
	}

	public Long getTransId() {
		return transId;
	}

	public String getTransName() {
		return transName;
	}

	public Date getDate() {
		return date;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setReceipt(Receipt receipt) {
		//this.receipt = receipt;
	}
	
}
