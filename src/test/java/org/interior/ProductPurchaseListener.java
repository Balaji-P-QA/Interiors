package org.interior;

import java.io.File; 
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductPurchaseListener extends Base implements ITestListener {

	ExtentTest test;
	
	ExtentReports extent = ProductExtenRepots.getReport();
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Pass");
		
				
	}

	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());
		
		String FilePath = null;
		
		try {
			
			FilePath = getScreenshot(result.getMethod().getMethodName());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
			
         test.addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
		
	
	}

	public void onTestSkipped(ITestResult result) {

		test.skip(result.getThrowable());
		
		
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	public void onStart(ITestContext context) {

		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

}
