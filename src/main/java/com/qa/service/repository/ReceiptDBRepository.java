package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.domain.Receipt;
import com.qa.domain.Transaction;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ReceiptDBRepository implements DBRepository {

	private static final Logger LOGGER = Logger.getLogger(DBRepository.class);

	@PersistenceContext(unitName="primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getEntity(Long id) {
		LOGGER.info("ReceiptDBRepository getEntity");
		Query query = manager.createQuery("Select a FROM receipt a where a.id = :id");
		query.setParameter("id", id);
		Receipt receipt = (Receipt) query.getResultList();
		return util.getJSONForObject(receipt);
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getAllFor(Long id) {
		LOGGER.info("ReceiptDBRepository getAllFor");
		Query query = manager.createQuery("Select a FROM receipt a where transaction.receipt.id = :id");
		query.setParameter("id", id);
		Collection<Receipt> receipt = (Collection<Receipt>) query.getResultList();
		return util.getJSONForObject(receipt);
	}

	@Override
	public String create(String receipt) {
		LOGGER.info("ReceiptDBRepository createReceipt");
		Receipt newReceipt = util.getObjectForJSON(receipt, Receipt.class);
		manager.persist(newReceipt);
		return "{\"message\": \"receipt has been sucessfully added\"}";
	}

	@Override
	public String delete(Long id) {
		LOGGER.info("ReceiptDBRepository deleteReceipt");
		Receipt receipt = findReceipt(id);
		if (receipt != null) {
			manager.remove(receipt);
			return "{\"message\": \"receipt sucessfully deleted\"}";
		}
		return "{\"message\": \"receipt not found\"}";
	}

	private Receipt findReceipt(Long id) {
		LOGGER.info("ReceiptDBRepository findTransaction");
		return manager.find(Receipt.class, id);
	}

}
