package com.rvy.cucumber.bdd.stepdefs;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.log.SysoCounter;
import com.rvy.entity.Customer;
import com.rvy.repository.CustomerRepository;
import com.rvy.service.CustomerService;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

public class CreateCustomerSteps extends AbstractSteps implements En {
	
	String programSideStatus = "Unsuccessful";
	boolean notNull = false;

	Customer customer = null;
	Customer fetchedCustomer;
//	@Autowired
//	private CustomerRepository cr;

  public CreateCustomerSteps(){
	
    Given("Admin wants to register a customer with the following attributes", (DataTable customerDt) -> {
      List<List<String>> customerData = customerDt.asLists(String.class);
      customer = populateCustomer(customerData.get(1));
      
//      fetchedCustomer = cr.save(customer);

    });
    
    Given("Admin wants to register a new customer", () -> {
        
      });

    When("admin register the new customer", () -> {
    	Integer fetchedUin = customer.getUin();
    	notNull = fetchedUin.toString().isEmpty()? false:true;
    });
    
    When("Customer name is {string} and mobile number is {string}", (String name, String number) -> {
    	if(!name.isEmpty() && !number.isBlank()) {
    		programSideStatus = "Successful";
    	}
    });

    Then("the registration is successful", () -> {
    	assertTrue(notNull);    	
    });
    
    Then("The registration is {string}", (String status) -> {
    	   	switch(status) {
    	   	case "Successful":
    	   		assertEquals(programSideStatus,"Successful");
    	   		break;
    	   	case "Unsuccessful":
    	   		assertEquals(programSideStatus,"Unsuccessful");
    	   		break;
    	   	default:
    	          fail("Unexpected error");
    	   	}
    });

  }
private Customer populateCustomer(List<String> list) {
	Customer customer = new Customer();
	
//	customer.setCustomerId(Integer.parseInt(list.get(0)));
//	customer.setUin(Integer.parseInt(list.get(1)));
//	customer.setName(list.get(2));
//	customer.setEmail(list.get(3));
//	customer.setMobile(Long.parseLong(list.get(4)));
//	customer.setBirthdate(LocalDate.parse(list.get(5)));
//	customer.setDoorNumber(list.get(6));
//	customer.setStreet(list.get(7));
//	customer.setCity(list.get(8));
//	customer.setState(list.get(9));
//	customer.setCountry(list.get(10));
//	customer.setZipCode(Long.parseLong(list.get(11)));
//	customer.setRegionId(Integer.parseInt(list.get(12)));
	
	
	customer.setUin(Integer.parseInt(list.get(0)));
	customer.setName(list.get(1));
	customer.setEmail(list.get(2));
	customer.setMobile(Long.parseLong(list.get(3)));
	customer.setBirthdate(LocalDate.parse(list.get(4)));
	customer.setDoorNumber(list.get(5));
	customer.setStreet(list.get(6));
	customer.setCity(list.get(7));
	customer.setState(list.get(8));
	customer.setCountry(list.get(9));
	customer.setZipCode(Long.parseLong(list.get(10)));
	customer.setRegionId(Integer.parseInt(list.get(11)));

	return customer;
}
}
