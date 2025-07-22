package com.Demowebshopqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	@FindBy(id="Email")
	WebElement email;
	@FindBy(id="Password")
	WebElement password;
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement loginbutton;
	@FindBy(xpath="//span[text()='Please enter a valid email address.']")
	WebElement actualmessage;
	@FindBy(xpath="//div[@class='validation-summary-errors']/ul/li")
	WebElement actualwarning;
	
	public Loginpage(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logindetails(String username,String Password)
	{
		email.sendKeys(username);
		password.sendKeys(Password);
	}
	
	public void submit()
	{
		loginbutton.click();
	}
	public String message()
	{
		return actualmessage.getText();
	}
	public String warningmessage()
	{
		return actualwarning.getText();
	}
	
}
