package com.rvy.cucumber.bdd.stepdefs;


import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.rvy.entity.Customer;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

public class FindCustomerSteps extends AbstractSteps implements En {

	boolean notNull = false;
	@Autowired
	Customer customer;
	List<Customer> customerList = new ArrayList<Customer>();
	boolean found = false;
	public FindCustomerSteps() {

		Given("The following customer exists and Admin wants to find the customer by ID", (DataTable customerDt) -> {
			testContext().reset();
			List<List<String>> customerData = customerDt.asLists(String.class);
			customerList.add(populateCustomer(customerData.get(1)));
			customerList.add(populateCustomer(customerData.get(2)));
		});

		When("admin wants to find the customer with ID {string}", (String id) -> {	
			Integer custId = Integer.parseInt(id);
			for(Customer c: customerList) {
				if(c.getCustomerId().equals(custId)) {
					found =true;
				}
			}
		});

		Then("the customer is found", () -> {
			assertTrue(found);
		});

	}

	private Customer populateCustomer(List<String> list) {
		Customer customer = new Customer();
		customer.setCustomerId(Integer.parseInt(list.get(0)));
		customer.setUin(Integer.parseInt(list.get(1)));
		customer.setName(list.get(2));
		customer.setEmail(list.get(3));
		customer.setMobile(Long.parseLong(list.get(4)));
		customer.setBirthdate(LocalDate.parse(list.get(5)));
		customer.setDoorNumber(list.get(6));
		customer.setStreet(list.get(7));
		customer.setCity(list.get(8));
		customer.setState(list.get(9));
		customer.setCountry(list.get(10));
		customer.setZipCode(Long.parseLong(list.get(11)));
		customer.setRegionId(Integer.parseInt(list.get(12)));
		return customer;
	}
}

