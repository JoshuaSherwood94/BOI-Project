package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.service.repository.AccountDBRepository;

public class AccountService implements Service {
	
	private static final Logger LOGGER = Logger.getLogger(AccountService.class);

	@Inject
	private AccountDBRepository repo;

	@Override
	public String getAll() {
		LOGGER.info("AccountService-getAll");
		return repo.getAll();
	}

	@Override
	public String getEntity(long id) {
		LOGGER.info("AccountService-getEntity-ID=" + id);
		return repo.get(id);
	}

	@Override
	public String createEntity(String ent) {
		LOGGER.info("AccountService-createEntity-\nEntity created values = " + ent);
		return repo.add(ent);
	}

	@Override
	public String removeEntity(Long id) {
		LOGGER.info("AccountService-removeEntity-ID=" + id);
		return repo.remove(id);
	}

	@Override
	public String getAllFor(Long id) {
		LOGGER.info("AccountService-getAllFor-ID=" + id);
		return repo.getAllFor(id);
	}

}
