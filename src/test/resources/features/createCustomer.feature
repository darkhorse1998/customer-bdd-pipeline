Feature: Registering a customer

	Mandatory details for registering a new customer can be his/her name,Unique ID and mobile number.
	
  Scenario: For registering a new customer, his/her Unique ID should not be blank.
	
    Given Admin wants to register a customer with the following attributes
      | uin  | name         | email             | mobile     | birthdate | doorNumber   | street   |city   | state       | country |zipCode |regionId |
    	| 17080  | Andhera kayam | ak@gmail.com | 9777172228 | 2009-01-01| Door 9	    | Street 7  |Anandapur   | Odisha | India   |769007  |1214  |
    When admin register the new customer
    Then the registration is successful
    
    
  Scenario Outline: For registering a new customer, his/her name and mobile number cannot be blank.
  
  	Given Admin wants to register a new customer
  	When Customer name is "<name>" and mobile number is "<number>"
  	Then The registration is "<status>"
  	
  	Examples:
  	
  	|      name     |   number   |status      |
  	|Robert Kiyosaki| 6782496318 |Successful  |
  	|Sally Hawkins  |            |Unsuccessful|
  	|Morgan Housel	| 9536741936 |Successful  |
  	|               |            |Unsuccessful|
  	|               | 6974696365 |Unsuccessful|
  	|Benjamin Graham| 8536651934 |Successful  |
  	
  	
