package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

@Transactional(SUPPORTS)
@Default
public interface Repository{
	
	public String get(long id);
	public String remove(long id);
	public String add(String entity);
	public String getAll();
	public String getAllFor(long id);
}
