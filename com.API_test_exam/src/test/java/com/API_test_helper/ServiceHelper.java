package com.API_test_helper;

import java.util.Properties;

import org.testng.annotations.BeforeClass;

import com.API_test.constants.EndPoints;
import com.API_test.models.AddUserPOJO;
import com.API_test.models.DeleteUserPOJO;
import com.API_test.utils.Utils_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class ServiceHelper extends ReusableMethods{

	@BeforeClass
	public void setUp() {
		Utils_API UT = new Utils_API();
		Properties PropertiesFile = UT.loadfile("getdataProperties");
		RestAssured.baseURI = UT.getProperty("baseuri",PropertiesFile);
	}
	
	public static Response getuser() {
	Response res = RestAssured
	.given()
	.when()
	.get(EndPoints.GET_DATA);
	return res;
	}
	
	public static Response createuser() {
		Utils_API UT = new Utils_API();
		Properties PropertiesFile = UT.loadfile("getdataProperties");
		AddUserPOJO createuserdetails = new AddUserPOJO();
		createuserdetails.setEmployee_name(UT.getProperty("name",PropertiesFile));
		createuserdetails.setEmployee_salary(UT.getProperty("salary",PropertiesFile));
		createuserdetails.setEmployee_age(UT.getProperty("age",PropertiesFile));
		createuserdetails.setProfile_image(UT.getProperty("image",PropertiesFile));
		System.out.println("got createuserdetails details");
		Response res = RestAssured
						.given()						
						.contentType(ContentType.JSON)
						.body(createuserdetails)
						.when()
						.post(EndPoints.CREATE_DATA);
		System.out.println("response got it");
		return res;
		
	}
	
	public static Response deleteuser() {
		Utils_API UT1 = new Utils_API();
		Properties PropertiesFile1 = UT1.loadfile("writedataProperties");
		DeleteUserPOJO deleteuserid = new DeleteUserPOJO();
		deleteuserid.setId1(UT1.getProperty("id1",PropertiesFile1));
		String idvalue = deleteuserid.getId1();
		Response res = RestAssured
						.given()
						.pathParam("id", idvalue)
						.contentType(ContentType.JSON)
						
						.when()
						.delete(EndPoints.DELETE_DATA);
		return res;
	}
	public static Response deleteuserAgain() {
		Utils_API UT1 = new Utils_API();
		Properties PropertiesFile1 = UT1.loadfile("writedataProperties");
		DeleteUserPOJO deleteuserid = new DeleteUserPOJO();
		deleteuserid.setId1(UT1.getProperty("id1",PropertiesFile1));
		String idvalue = deleteuserid.getId1();
		Response res = RestAssured
						.given()
						.pathParam("id", 0)
						.contentType(ContentType.JSON)
						
						.when()
						.delete(EndPoints.DELETE_DATA);
		return res;
	}
	
	public static Response getEmployeewithid() {
		Response res = RestAssured
				.given()
				.pathParam("id", 2)
				.contentType(ContentType.JSON)
				
				.when()
				.get(EndPoints.GET_SingleDATA);
		return res;
	}
}



