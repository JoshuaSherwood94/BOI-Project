package com.qa.intigration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.business.ReceiptItemsService;

@Path("/receiptItems")
public class ReceiptItemsEndpoint {
	@Inject
	private ReceiptItemsService service;
	
	@Path("/json/{i}")
	@GET
	@Produces({ "application/json" })
	public String getReceiptItems(@PathParam("i") Long id) {
		return service.getEntity(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addReceiptItems(String receipt) {
		return service.createEntity(receipt);
	}

	@Path("/json/{i}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteReceiptItems(@PathParam("i") Long id) {
		return service.removeEntity(id);

	}

	public void setService(ReceiptItemsService service) {
		this.service = service;
	}

}
