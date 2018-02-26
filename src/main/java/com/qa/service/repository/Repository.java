package com.qa.service.repository;

import com.qa.domain.DomainEntity;

public interface Repository{
	
	public DomainEntity get(int id);
	public DomainEntity remove(int id);
	public DomainEntity add(DomainEntity entity);

}
