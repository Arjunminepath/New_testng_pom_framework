package com.demowebshopqa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Demowebshopqa.pages.Searchpage;
import com.Demowebshopqa.pages.Searchresultspage;
import com.demowebshopqa.base.Base;

import junit.framework.Assert;

public class Searchtest extends Base {
	
public WebDriver driver;
Searchpage sp;
Searchresultspage srp;
    public Searchtest()
    {
    	super();
    }
	@BeforeMethod
	public void setup()
	{
		driver = InitializeBrowser(prop.getProperty("browser"));
		sp=new Searchpage(driver);
		sp.search();
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority = 2)
	public void VerifySearchWithValidProduct() throws InterruptedException
	{
		sp.entersearch(dataprop.getProperty("validproduct"));
		sp.searchsubmit();
		String actualmessage = srp.resultcontent();
		String expectedmessage = "14.1-inch Laptop";
		Assert.assertEquals(actualmessage, expectedmessage);
	}
	
	@Test(priority = 1)
	public void VerifySearchWithInvalidProduct()
	{
		sp.entersearch(dataprop.getProperty("Invalidproduct"));
		sp.searchsubmit();
		String actualmessage = srp.errorresultcontent();
		Assert.assertEquals(actualmessage, "No products were found that matched your criteria.");
	}
}
