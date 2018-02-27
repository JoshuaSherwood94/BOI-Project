package com.qa.service.business;

import javax.inject.Inject;

import com.qa.service.repository.ReceiptDBRepository;

public class ReceiptService implements Service{
	@Inject
	ReceiptDBRepository repo;
	
	public String getAllReceiptsFor(Long id){
		return repo.getAllFor(id);
	}
	
	public String getReceipt(Long id){
		return repo.getEntity(id);
	}
	
	public String deleteReceipt(Long id){
		return repo.delete(id);
	}
	
	public String createReceipt(String transaction){
		return repo.create(transaction);
	}
	
	public void setRepo(ReceiptDBRepository repo){
		this.repo = repo;
	}
}
