package com.demowebshopqa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Demowebshopqa.utils.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	
	public Properties dataprop;
	
	public Base()
	{
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Demowebshopqa\\config\\Config.properties");
		
		dataprop = new Properties();
		File Datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Demowebshopqa\\testdata\\testdata.properties");
		try
		{
			FileInputStream datafis = new FileInputStream(Datapropfile);
			dataprop.load(datafis);
		}
		catch(Throwable e)
		{
		e.printStackTrace();	
		}
		try
		{
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	public WebDriver InitializeBrowser(String browserName)
	{
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
