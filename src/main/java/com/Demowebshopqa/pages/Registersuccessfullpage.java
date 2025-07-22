package com.Demowebshopqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registersuccessfullpage {

	WebDriver driver;
	@FindBy(xpath="//div/div[normalize-space(text())='Your registration completed']")
	WebElement message;
	
	public Registersuccessfullpage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public String completionmessage()
	{
		return message.getText();
	}
	
}
