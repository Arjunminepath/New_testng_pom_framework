package com.Demowebshop.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Demowebshopqa.utils.Extentreports;
import com.Demowebshopqa.utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Mylisteners implements ITestListener {

	ExtentReports extentreports;
	ExtentTest extenttest;
	String testname;
	@Override
	public  void onStart(ITestContext context) {
		extentreports = Extentreports.generateExtentreport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
	
		extenttest= extentreports.createTest(result.getName());
		extenttest.log(Status.INFO, testname+"started executing"); 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		extenttest.log(Status.INFO, result.getName()+"got executed successfully"); 
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		testname = result.getName();
		System.out.println( "screenshot taken");
		
		WebDriver driver = null;
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String destinationpath = Utilities.capturescreenshot(driver, result.getName());
		extenttest.addScreenCaptureFromPath(destinationpath);
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL,result.getName()+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testname = result.getName();
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP,result.getName()+"got skipped");
	}

	
	 @Override
	public void onFinish(ITestContext context) {
		
		extentreports.flush();
		
		String pathofextentreport = System.getProperty("user.dir")+"//test-output//Extentreports//extentReports.html";
		File extentreport = new File(pathofextentreport);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
