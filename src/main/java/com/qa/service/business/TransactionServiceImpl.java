package com.qa.service.business;

import javax.inject.Inject;

import com.qa.service.repository.DBRepository;
import com.qa.service.repository.TransactionDBRepository;

public class TransactionServiceImpl implements Service{

	@Inject
	DBRepository repo;
	
	public String getAllTransactionsFor(Long id){
		return repo.getAllFor(id);
	}
	
	public String getTransaction(Long id){
		return repo.getEntity(id);
	}
	
	public String deleteTransaction(Long id){
		return repo.delete(id);
	}
	
	public String createTransaction(String transaction){
		return repo.create(transaction);
	}
	
	public void setRepo(TransactionDBRepository repo){
		this.repo = repo;
	}
}
