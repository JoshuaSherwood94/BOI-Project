package com.qa.service.business;

import javax.inject.Inject;

import com.qa.service.repository.ReceiptDBRepository;

public class ReceiptService implements Service{
	@Inject
	ReceiptDBRepository repo;
	
	public void setRepo(ReceiptDBRepository repo){
		this.repo = repo;
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntity(long id) {
		return repo.getEntity(id);
	}

	@Override
	public String createEntity(String ent) {
		return repo.create(ent);
	}

	@Override
	public String removeEntity(Long id) {
		return repo.delete(id);
	}

	@Override
	public String getAllFor(Long id) {
		return repo.getAllFor(id);
	}
}
