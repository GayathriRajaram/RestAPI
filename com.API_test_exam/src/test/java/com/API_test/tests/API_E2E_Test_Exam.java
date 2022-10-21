package com.API_test.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.API_test.simpleCRUD.*;
import com.API_test_helper.ServiceHelper;

@Listeners(com.API_test.utils.Listeners.class)

public class API_E2E_Test_Exam extends ServiceHelper{

	@Test(priority = 1)
	public static void TC_01_AllEmployeedata() {
		GetAllEmployee.getEmployees();
		
	}
	@Test(priority = 2)
	
	public static void TC_02_CreateEmployeedata() {
		System.out.println("Going to add employee:");
		Create_Employee.AddEmployee();
	}
	@Test(priority = 3)
	public static void TC_03_DeleteEmployee() {
		DeleteEmployee.delete_emp();
	}
	@Test(priority = 4)
	public static void TC_04_DeleteAlreadydeletedEmployee() {
		DeleteEmployee.delete_again();

	}
	@Test(priority = 5)
	public static void TC_05_GetEmpWithId() {
		GetEmployee.getempwithid();
	}
}
