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
public class Transaction {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id @Column(name="transaction_id")
	private int transId;
	@Column(name="transaction_name") @Size(max=45)
	private String transName;
	@Column(name="date")
	private Calendar date;
	@ManyToOne
	@Column(name="Account_Id")
	@ForeignKey(name="FK_Account")
	private Account accnt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="transaction_id")
	@NotFound(action=NotFoundAction.IGNORE)
	Receipt receipt;
	
	public Transaction() {
		
	}

	public Transaction(int transId, String transName, Calendar date, Account accnt) {
		super();
		this.transId = transId;
		this.transName = transName;
		this.date = date;
		this.accnt = accnt;
	}

	public int getTransId() {
		return transId;
	}

	public String getTransName() {
		return transName;
	}

	public Calendar getDate() {
		return date;
	}

	public Account getAccnt() {
		return accnt;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setAccnt(Account accnt) {
		this.accnt = accnt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	
}
