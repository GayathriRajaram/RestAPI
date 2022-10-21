package com.API_test.simpleCRUD;

import com.API_test_helper.ServiceHelper;

import io.restassured.response.Response;

public class GetEmployee extends ServiceHelper{
	
	public static void getempwithid() {
		Response Gres = getEmployeewithid();
		ResponsePrint(Gres);
		verifystatuscode(Gres,200);
		validate_equal(Gres,"status","success");
		validatecontentType(Gres,"application/json");
		validate_equal(Gres,"data.employee_name","Garrett Winters");
		validate_equalInteger(Gres,"data.employee_salary","170750");
		validate_equalInteger(Gres,"data.employee_age","63");
	}

}
