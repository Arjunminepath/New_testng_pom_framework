package com.demowebshopqa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Demowebshopqa.pages.Homepage;
import com.Demowebshopqa.pages.Registerpage;
import com.Demowebshopqa.pages.Registersuccessfullpage;
import com.Demowebshopqa.utils.Utilities;
import com.demowebshopqa.base.Base;

public class Registertest extends Base{
	

	public WebDriver driver;
	Homepage homepage;
	Registerpage rp;
	Registersuccessfullpage rsp;
	
	public Registertest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver = InitializeBrowser(prop.getProperty("browser"));
		homepage = new Homepage(driver);
		rp=homepage.registerclick();
		System.out.println("sample for change");
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority = 2)
	public void VerifyregisterWithValidDetails()
	{
		
		rp.selectgender();
		rp.firstnamefield(dataprop.getProperty("firstname"));
		rp.lastnamefield(dataprop.getProperty("lastname"));
		rp.mailidfield("arjun"+Utilities.gettimestamp()+"@gmail.com");
		rp.passwordfield(dataprop.getProperty("password"));
		rp.confpasswordfield(dataprop.getProperty("password"));
		rsp=rp.registerbutton();
		String actualmessage=rsp.completionmessage();
		Assert.assertEquals(actualmessage,"Your registration completed");
		
	}
	@Test(priority = 1)
	public void VerifywithEmptyPasswordfields()
	{
		rp.selectgender();
		rp.firstnamefield(dataprop.getProperty("firstname"));
		rp.lastnamefield(dataprop.getProperty("lastname"));
		rp.mailidfield(dataprop.getProperty("mailid"));
		rp.registerbutton();
		String errormessage = rp.messageerror();
		Assert.assertEquals(errormessage, "Password is required.");
	}
	
		
}
