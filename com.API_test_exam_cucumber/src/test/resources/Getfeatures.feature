Feature:Get Method 

Background: 
	Given The endpoint is up and running
	
	
Scenario: Find the number of Employee Exits
		When send request to end point employees
		Then Response should have the list of employee details
		Then Validate the status code and body message 
		
		
Scenario: Get the Details of the employee whoes id 
		When send request to end point employeeid
		Then Response should have the particular of employee details
		Then Validate the status code and body message
					

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					