package com.StepDefinition;

import com.API_test.models.GetEmployeeRootPOJO;
import com.API_test_helper.ServiceHelper;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinitionGetMethod extends ServiceHelper{
	public GetEmployeeRootPOJO GList;
	public static Response Gres;
	public static Response GEmp;
	@Given("The endpoint is up and running")
	public void The_endpoint_is_up_and_running() {
		setUp();
	}
	
	@When("send request to end point employees")
	public void send_request_to_end_point_employees() {
		Gres = getuser();
		 GList = Gres.as(GetEmployeeRootPOJO.class);
	}
	
	@Then("Response should have the list of employee details")
	public void Response_details(){
		getStatusCode(Gres);
		verifystatuscode(Gres,200);
		validate_equal(Gres,"status","success");
		String size = GetDataFromResponse(Gres,"data.size()");
		System.out.println("No of data on the records are :"+size);
		

	}
	

	@Then("Validate the status code and body message")
	public void validate_the_status_code_and_body_message() {
		ResponsePrint(Gres);
		validate_equal(Gres,"status","success");
		System.out.println(GList);
	}

	@When("send request to end point employeeid")
	public void send_request_to_end_point_employeeid() {
		GEmp = getEmployeewithid();
		ResponsePrint(GEmp);

	}

	@Then("Response should have the particular of employee details")
	public void response_should_have_the_of_employee_details() {
		verifystatuscode(GEmp,200);
		validate_equal(GEmp,"status","success");
		validatecontentType(GEmp,"application/json");
		validate_equal(GEmp,"data.employee_name","Garrett Winters");
		validate_equalInteger(GEmp,"data.employee_salary","170750");
		validate_equalInteger(GEmp,"data.employee_age","63");
	}
}
