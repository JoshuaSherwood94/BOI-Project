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

import com.qa.domain.Account;
import com.qa.domain.Customer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements Repository {
	
	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);
	
	private Account findAccount(Long id) {
		LOGGER.info("AccountRepository findAccount");
		return manager.find(Account.class, id);
	}

	@Override
	public String get(long id) {
		LOGGER.info("AccountRepository get");
		return  util.getJSONForObject(manager.find(Account.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String remove(long id) {
		LOGGER.info("AccountRepository deleteAccount");
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
			return "{\"message\": \"account sucessfully deleted\"}";
		}
		return "{\"message\": \"account not found\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String add(String entity) {
		LOGGER.info("AccountRepository createAccount");
		Account anAccount = util.getObjectForJSON(entity, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	public String getAll() {
		LOGGER.info("AccountRepository getAllAccounts");
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getAllFor(long id) {
		
		LOGGER.info("AccountRepository getAllAccounts");
		Query query = manager.createQuery("Select a FROM Account a where idcustomer ="+ id );
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
		
	}


	
}
