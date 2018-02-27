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
import com.qa.domain.Transaction;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TransactionDBRepository implements DBRepository{

	private static final Logger LOGGER = Logger.getLogger(DBRepository.class);
	
	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	public String getEntity(Long id) {
		LOGGER.info("TransactionDBRepository getEntity");
		Query query = manager.createQuery("Select a FROM transaction a where a.transaction_id = :id");
		query.setParameter("id", id);
		Transaction transaction = (Transaction) query.getResultList();
		return util.getJSONForObject(transaction);
	}

	@Override
	public String getAllFor(Long id) {
		LOGGER.info("TransactionDBRepository getAllFor");
		Query query = manager.createQuery("Select a FROM transaction a where a.idacount = :id");
		query.setParameter("id", id);
		Collection<Transaction> transactions = (Collection<Transaction>) query.getResultList();
		return util.getJSONForObject(transactions);
	}
	
	@Override
	public String create(String transaction) {
		LOGGER.info("TransactionDBRepository createTransaction");
		Transaction newTransaction = util.getObjectForJSON(transaction, Transaction.class);
		manager.persist(newTransaction);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	public String delete(Long id) {
		LOGGER.info("TransactionDBRepository deleteTransaction");
		Transaction transaction = findTransaction(id);
	if (transaction != null) {
		manager.remove(transaction);
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	return "{\"message\": \"account not found\"}";
	}

	private Transaction findTransaction(Long id) {
		LOGGER.info("TransactiuonDBRepository findTransaction");
		return manager.find(Transaction.class, id);
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return "";
	}

}
