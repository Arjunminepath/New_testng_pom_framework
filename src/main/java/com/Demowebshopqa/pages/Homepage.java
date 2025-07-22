package com.Demowebshopqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	@FindBy(className = "ico-login")
	WebElement loginlink;
	@FindBy(className = "ico-register")
	WebElement registerlink;
	@FindBy(linkText="Harsha0601@gmail.com")
	WebElement mailid;
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Loginpage clicklogin()
	{
		loginlink.click();
		return new Loginpage(driver);
	}
	public Registerpage registerclick()
	{
		registerlink.click();
		return new Registerpage(driver);
	}
	public boolean mail()
	{
		return mailid.isDisplayed();
	}
}
