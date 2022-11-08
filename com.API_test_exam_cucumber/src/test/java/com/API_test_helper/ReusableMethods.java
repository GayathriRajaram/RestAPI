package com.API_test_helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.hamcrest.Matchers;

import com.API_test.constants.SourcePath;

//import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ReusableMethods {
	
public FileInputStream stream=null;
	public static void writeProperty(String id) throws IOException {
		File file = new File(SourcePath.WRITE_PROPERTIES_PATH);
		FileOutputStream os = new FileOutputStream(file);
		Properties propertyFile = new Properties();		
		propertyFile.put("id1", id);
		propertyFile.store(os, "id File written");
	}
	public static void writeProperty(String userid,String id) throws IOException {
		File file = new File(SourcePath.WRITE_PROPERTIES_PATH);
		FileOutputStream os = new FileOutputStream(file);
		Properties propertyFile = new Properties();
		propertyFile.put("userid1", userid);
		propertyFile.put("id1", id);
		propertyFile.store(os, "sampleFile written");
	}
	public static int getStatusCode(Response res) {
		
		return res.getStatusCode();
		 
	}
	public static void verifystatuscode(Response res, int code) {
		res.then().statusCode(code);

	}
	public static String getContentType(Response res) {
		return res.getContentType();
	}
	public static void validatecontentType(Response res,String contenttype) {
		res.then().contentType(contenttype);
	}
	
	public static String GetDataFromResponse(Response res, String path) {
		String result=res.jsonPath().getString(path);	
		return result;
	}
	public static void validate_equal(Response res,String path,String match) {
		res.then().body(path,Matchers.equalTo(match));

	}
	public static void validate_equalInteger(Response res,String path,String match) {
		res.then().body(path,Matchers.equalTo(Integer.parseInt(match)));

	}
	
	//public static void Schemavalidation(Response res,String filename) {
		//res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(filename));	

	//}
	public static void ResponsePrint(Response res) {
		res.prettyPrint();
	}
}
