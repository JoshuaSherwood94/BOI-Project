package com.qa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Target;

@Entity
public class Account implements DomainEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idAccount")
	private Long id;
	@Size(max=500)
	@Column(name="account_Desc")
	private String description;
	@Size(max=10)
	@Column(name="account_Type")
	private String type;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="idAcount")
	private Set<Transaction> transRefs = new HashSet<>();

	public Account(String accountDescription, String accountType, int customerID) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
