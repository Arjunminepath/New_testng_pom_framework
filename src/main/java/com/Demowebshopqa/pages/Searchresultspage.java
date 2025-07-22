package com.Demowebshopqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchresultspage {
	
	WebDriver driver;
	

	@FindBy(xpath="//a[text()='14.1-inch Laptop']")
	WebElement resulttext;
	@FindBy(xpath="//div/strong[normalize-space(text())='No products were found that matched your criteria.']")
	WebElement errorresulttext;
	
	public Searchresultspage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String resultcontent()
	{
		return resulttext.getText();
	}
	public String errorresultcontent()
	{
		return errorresulttext.getText();
	}
	
}
