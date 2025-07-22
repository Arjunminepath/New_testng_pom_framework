package com.Demowebshopqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='small-searchterms']")
	WebElement searchfield;
	@FindBy(xpath="//input[@class='button-1 search-box-button']")
	WebElement searchbutton;
	
	public Searchpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search()
	{
		searchfield.click();
	}
	public void entersearch(String product)
	{
		searchfield.sendKeys(product);
	}
	public void searchsubmit()
	{
		searchbutton.click();
	}
}
