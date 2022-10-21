package com.API_test.simpleCRUD;

import java.io.IOException;

import com.API_test.models.*;
import com.API_test_helper.ServiceHelper;

import io.restassured.response.Response;

public class Create_Employee extends ServiceHelper {
		public static void AddEmployee() {
			System.out.println("Inside add employee");
			Response Cres = createuser();
			System.out.println("created user");
			CreatedUserPOJORootResponse CList = Cres.as(CreatedUserPOJORootResponse.class);
			System.out.println(CList);
			ResponsePrint(Cres);
			getStatusCode(Cres);
			verifystatuscode(Cres,200);
			validate_equal(Cres,"status","success");
			String name = GetDataFromResponse(Cres,"data.employee_name");
			String age = GetDataFromResponse(Cres,"data.employee_age");
			String salary = GetDataFromResponse(Cres,"data.employee_salary");
			String id = GetDataFromResponse(Cres,"data.id");
			System.out.println("name is :"+name);
			System.out.println("age is :"+age);
			System.out.println("salary is :"+salary);
			System.out.println("id is :"+id);

			validate_equal(Cres,"data.employee_name","test");
			validate_equal(Cres,"data.employee_salary","123");
			validate_equal(Cres,"data.employee_age","23");
			try {
				writeProperty(id);
			} catch (IOException e) {
				e.printStackTrace();
			}


			
		}
}
