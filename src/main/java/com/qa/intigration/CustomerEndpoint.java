package com.qa.intigration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.service.business.CustomerService;

@Path("/customer")
public class CustomerEndpoint {

	private static final Logger LOGGER = Logger.getLogger(CustomerEndpoint.class);

	@Inject
	private CustomerService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCustomers() {
		LOGGER.info("CustomerEndpoint + getAllCustomers");
		return service.getAll();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCustomer(String customer) {
		LOGGER.info("CustomerEndpoint + addCustomer");
		return service.createEntity(customer);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCustomer(@PathParam("id") Long id) {
		LOGGER.info("CustomerEndpoint + deleteCustomer");
		return service.removeEntity(id);

	}

	public void setService(CustomerService service) {
		LOGGER.info("CustomerEndpoint + setService");
		this.service = service;
	}

}
