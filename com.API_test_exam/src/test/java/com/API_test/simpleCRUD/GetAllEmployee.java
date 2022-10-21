package com.API_test.simpleCRUD;

import com.API_test.models.*;
import com.API_test_helper.ServiceHelper;

import io.restassured.response.Response;

public class GetAllEmployee extends ServiceHelper {
	
	public static void getEmployees() {
		
	Response Gres = getuser();
	GetEmployeeRootPOJO GList = Gres.as(GetEmployeeRootPOJO.class);
	System.out.println(GList);
	getStatusCode(Gres);
	verifystatuscode(Gres,200);
	validate_equal(Gres,"status","success");
	String size = GetDataFromResponse(Gres,"data.size()");
	System.out.println("No of data on the records are :"+size);

	
}
}