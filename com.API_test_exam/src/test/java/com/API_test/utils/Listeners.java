package com.API_test.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.API_test.constants.SourcePath;
import com.API_test_helper.ServiceHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends ServiceHelper implements ITestListener{
	

	protected static ExtentReports reports;
	protected static ExtentTest test;

	private static String resultpath = SourcePath.GENERATE_REPORT_PATH;		
	
	public void onTestStart(ITestResult result) {

		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test is pass");

	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.INFO, "Failed");
		test.log(LogStatus.FAIL, "Test is fail");

	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println(resultpath + "  ReportLocation");
		reports = new ExtentReports(resultpath + "ExtentReport.html");
		test = reports.startTest("");
		test.log(LogStatus.INFO, "Starting");

	}

	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();

	}
}


 


