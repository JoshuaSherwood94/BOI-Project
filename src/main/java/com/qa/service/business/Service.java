package com.qa.service.business;

public interface Service {
	
	public String getAll();
	public String getEntity(long id);
	public String createEntity(String ent);
	public String removeEntity(Long id);
	public String getAllFor(Long id);
}
