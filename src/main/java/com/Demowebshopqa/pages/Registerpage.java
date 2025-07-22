package com.Demowebshopqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

	WebDriver driver;
	
	@FindBy(id="gender-male")
	WebElement gender;
	@FindBy(id="FirstName")
	WebElement firstname;
	@FindBy(id="LastName")
	WebElement lastname;
	@FindBy(id="Email")
	WebElement mailid;
	@FindBy(id="Password")
	WebElement password;
	@FindBy(id="ConfirmPassword")
	WebElement confpassword;
	@FindBy(xpath="//input[@id='register-button']")
	WebElement registersubmit;
	@FindBy(xpath="//input[@id='Password']//following::span[2]")
	WebElement errormessage;
	
	public Registerpage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void selectgender()
	{
		gender.click();
	}
	public void firstnamefield(String first_name)
	{
		firstname.sendKeys(first_name);
	}
	public void lastnamefield(String last_name)
	{
		lastname.sendKeys(last_name);
	}
	public void mailidfield(String email_id)
	{
		mailid.sendKeys(email_id);
	}
	public void passwordfield(String Password)
	{
		password.sendKeys(Password);
	}
	public void confpasswordfield(String conf_password)
	{
		confpassword.sendKeys(conf_password);
	}
	public Registersuccessfullpage registerbutton()
	{
		registersubmit.click();
		return new Registersuccessfullpage(driver);
	}
	public String messageerror()
	{
		return errormessage.getText();
	}
}
