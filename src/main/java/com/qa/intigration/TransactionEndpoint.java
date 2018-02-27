package com.qa.intigration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.business.TransactionServiceImpl;

@Path("/transaction")
public class TransactionEndpoint {
	@Inject 
	TransactionServiceImpl service;
	
	@Path("/json/{i}")
	@GET
	@Produces({ "application/json" })
	public String getAllATransactionsFor(@PathParam("i")Long id) {
		return service.getAllFor(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addTransaction(String transaction) {
		return service.createEntity(transaction);
	}
	//comment
	@Path("/json/{i}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTransaction(@PathParam("i") Long id) {
		return service.removeEntity(id);

	}

	public void setService(TransactionServiceImpl service) {
		this.service = service;
	}
}
