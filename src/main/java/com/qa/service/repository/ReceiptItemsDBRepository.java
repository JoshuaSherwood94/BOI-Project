package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.ReceiptItems;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ReceiptItemsDBRepository implements Repository{

	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	public String getEntity(Long id) {
		Query query = manager.createQuery("Select a FROM receiptItems a where a.id = :id");
		query.setParameter("id", id);
		ReceiptItems receiptItems = (ReceiptItems) query.getResultList();
		return util.getJSONForObject(receiptItems);
	}
	
	@Override
	public String get(long id) {
		return util.getJSONForObject(manager.find(ReceiptItems.class, id));
	}

	@Override
	public String remove(long id) {
		ReceiptItems receiptItems = util.getObjectForJSON(get(id), ReceiptItems.class);
		if (receiptItems != null) {
			manager.remove(receiptItems);
			return "{\"message\": \"receipt item sucessfully deleted\"}";
		}
		return "{\"message\": \"receipt item not found\"}";
	}

	@Override
	public String add(String entity) {
		ReceiptItems newReceiptItems = util.getObjectForJSON(entity, ReceiptItems.class);
		manager.persist(newReceiptItems);
		return "{\"message\": \"receipt item has been sucessfully added\"}";
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getAllFor(long id) {
		Query query = manager.createQuery("Select a FROM receiptItems a where receipt.receiptItemsRefs.id = :id");
		query.setParameter("id", id);
		Collection<ReceiptItems> receiptItems = (Collection<ReceiptItems>) query.getResultList();
		return util.getJSONForObject(receiptItems);
	}
	
}
