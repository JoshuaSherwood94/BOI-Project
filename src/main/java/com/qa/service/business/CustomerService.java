package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.service.repository.CustomerDBRepository;

public class CustomerService implements Service {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerService.class);

	@Inject
	private CustomerDBRepository repo;

	@Override
	public String getAll() {
		LOGGER.info("CustomerService-getAll");
		return repo.getAll();
	}

	@Override
	public String getEntity(long id) {
		LOGGER.info("CustomerService-getEntity-ID=" + id);
		return repo.get(id);
	}

	@Override
	public String createEntity(String ent) {
		LOGGER.info("CustomerService-createEntity \nEntity created values = " + ent);
		return repo.add(ent);
	}

	@Override
	public String removeEntity(Long id) {
		LOGGER.info("CustomerService-removeEntity-ID=" + id);
		return repo.remove(id);
	}

	@Override
	public String getAllFor(Long id) {
		LOGGER.info("CustomerService-getAllFor-ID=" + id);
		return repo.getAllFor(id);
	}

}
