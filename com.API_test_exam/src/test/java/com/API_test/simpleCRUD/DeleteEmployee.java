package com.API_test.simpleCRUD;

import com.API_test_helper.ServiceHelper;

import io.restassured.response.Response;

public class DeleteEmployee extends ServiceHelper{
	public static void delete_emp() {
	Response Dres = deleteuser();
	ResponsePrint(Dres);
	verifystatuscode(Dres,200);
	validate_equal(Dres,"status","success");
}
	public static void delete_again() {
		Response Dres = deleteuserAgain();
		ResponsePrint(Dres);
		verifystatuscode(Dres,400);
		validate_equal(Dres,"status","error");
	}
}