package com.qa.service.business;

import javax.inject.Inject;

import com.qa.service.repository.ReceiptItemsDBRepository;

public class ReceiptItemsService implements Service{
	@Inject
	ReceiptItemsDBRepository repo;
	
	public void setRepo(ReceiptItemsDBRepository repo){
		this.repo = repo;
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntity(long id) {
		return repo.get(id);
	}

	@Override
	public String createEntity(String ent) {
		return repo.add(ent);
	}

	@Override
	public String removeEntity(Long id) {
		return repo.remove(id);
	}

	@Override
	public String getAllFor(Long id) {
		return repo.getAllFor(id);
	}
}
