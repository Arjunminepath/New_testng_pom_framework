package com.demowebshopqa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Demowebshopqa.pages.Homepage;
import com.Demowebshopqa.pages.Loginpage;
import com.Demowebshopqa.utils.Utilities;
import com.demowebshopqa.base.Base;

public class Logintest extends Base {
	
	public WebDriver driver;
	Homepage homepage;
	Loginpage loginpage;
	
	
	public Logintest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		
		driver = InitializeBrowser(prop.getProperty("browser"));
		homepage = new Homepage(driver);
		loginpage=homepage.clicklogin();
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	@Test(priority = 1,dataProvider="Validcredentialsupplier")
	public void VerifyLoginWithValidCredentials(String mail,String password)
	{
		loginpage.logindetails(mail, password);
		loginpage.submit();
		boolean status = homepage.mail();
		Assert.assertTrue(status);
		
		
	}
	@DataProvider(name="Validcredentialsupplier")
	public Object[][] supplyTestData() throws IOException
	{
		Object[][] data= Utilities.getTestdataFromExcel("Login");
		
		return data;
	}
	
	@Test (priority = 3)
	public void VerifyLoginWithInvalidCredentials()
	{
	
		loginpage.logindetails("Harsha"+Utilities.gettimestamp()+"gmail.com", dataprop.getProperty("invalidpassword"));
		loginpage.submit();
		String actualmessage=loginpage.message();
		String expectedwarning = "Please enter a valid email address.";
		Assert.assertTrue(actualmessage.contains(expectedwarning));
		
		
	}
	@Test(priority = 2)
	public void VerifyloginWithValidemailAndinvalidpassword()
	{
	
		loginpage.logindetails(dataprop.getProperty("validamail"), dataprop.getProperty("Invalidpassword"));
		loginpage.submit();
		String actualwarningmessage = loginpage.warningmessage();
		String expectedwarning = "The credentials provided are incorrect";
		Assert.assertTrue(actualwarningmessage.contains(expectedwarning));
		
	}
	
	
}
