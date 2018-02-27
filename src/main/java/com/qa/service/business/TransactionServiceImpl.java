package com.qa.service.business;

import javax.inject.Inject;

import com.qa.service.repository.TransactionDBRepository;

public class TransactionServiceImpl implements Service{

	@Inject
	private TransactionDBRepository repo;
	
	public void setRepo(TransactionDBRepository repo){
		this.repo = repo;
	}

	@Override
	public String getAll() {
		return repo.getAll();
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
