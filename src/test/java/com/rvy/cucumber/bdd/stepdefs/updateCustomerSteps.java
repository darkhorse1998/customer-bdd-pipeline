package com.rvy.cucumber.bdd.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.rvy.entity.Customer;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

public class updateCustomerSteps extends AbstractSteps implements En {
	
	boolean notNull = false;
	@Autowired
	Customer customer;
	
  public updateCustomerSteps() {
	  	  
    Given("The following customer exists and Admin wants to update the name", (DataTable customerDt) -> {
      testContext().reset();
      
      List<List<String>> customerData = customerDt.asLists(String.class);
      customer = populateCustomer(customerData.get(1));  
    });

    When("admin updates the customer name to {string}", (String newName) -> {    	
    	customer.setName(newName);
    });

    Then("the update is done", () -> {
    	assertEquals("John Sam",customer.getName());   	
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

