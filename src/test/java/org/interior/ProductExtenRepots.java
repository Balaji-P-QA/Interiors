package org.interior;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProductExtenRepots {

	public static ExtentReports getReport() {

		String path = System.getProperty("user.dir") +"//ReportsCollection//Repo.index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Login Results");
		reporter.config().setDocumentTitle("Results of Login");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Balaji.P");	
		return extent;
		
	}
	
	
}
