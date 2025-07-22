package com.Demowebshopqa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Extentreports {

	public static ExtentReports generateExtentreport() 
	{
		ExtentReports extentreports = new ExtentReports();
		File extentreportfile = new File(System.getProperty("user.dir")+"\\test-output\\Extentreports\\extentReports.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentreportfile);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Demowebshop automation result");
		spark.config().setDocumentTitle("demowebshop_report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentreports.attachReporter(spark);
		
		Properties configprop=new Properties();
		File congigpropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Demowebshopqa\\config\\Config.properties");
	    
		try {
			FileInputStream fisconfigprop = new FileInputStream(congigpropfile);
			configprop.load(fisconfigprop);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		  
	extentreports.setSystemInfo("Application URL",configprop.getProperty("url"));
	extentreports.setSystemInfo("browsername",configprop.getProperty("browsername"));
	
	return extentreports;
	
	}
	
}
