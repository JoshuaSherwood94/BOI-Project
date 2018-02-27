package com.qa.service.repository;

public interface DBRepository {
	String getAll();

	String getAllFor(Long id);
	
	String create(String accout);

	String delete(Long id);

	String getEntity(Long id);

}
