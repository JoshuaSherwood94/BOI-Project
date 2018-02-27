package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.domain.Customer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class CustomerDBRepository implements Repository {
	
	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	private static final Logger LOGGER = Logger.getLogger(CustomerDBRepository.class);
	
	private Customer findCustomer(Long id) {
		LOGGER.info("CustomerRepository findCustomer");
		return manager.find(Customer.class, id);
	}

	@Override
	public String get(long id) {
		LOGGER.info("CustomerRepository get");
		return  util.getJSONForObject(manager.find(Customer.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String remove(long id) {
		LOGGER.info("CustomerRepository deleteCustomer");
		Customer customerInDB = findCustomer(id);
		if (customerInDB != null) {
			manager.remove(customerInDB);
			return "{\"message\": \"customer sucessfully deleted\"}";
		}
		return "{\"message\": \"customer not found\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String add(String entity) {
		LOGGER.info("CustomerRepository createCustomer");
		Customer anCustomer = util.getObjectForJSON(entity, Customer.class);
		manager.persist(anCustomer);
		return "{\"message\": \"customer has been sucessfully added\"}";
	}
	
	public String getAll() {
		LOGGER.info("CustomerRepository getAllCustomers");
		Query query = manager.createQuery("Select a FROM Customer a");
		Collection<Customer> customers = (Collection<Customer>) query.getResultList();
		return util.getJSONForObject(customers);
	}
	
	public String getAllFor(long id) {
		LOGGER.info("CustomerRepository getAllCustomers");
		Query query = manager.createQuery("Select a FROM Customer where idAccount = '"+ id +"'a");
		Collection<Customer> customers = (Collection<Customer>) query.getResultList();
		return util.getJSONForObject(customers);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


	
}
