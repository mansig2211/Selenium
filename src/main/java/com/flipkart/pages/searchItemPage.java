package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class searchItemPage
{
	WebDriver driver;
	public searchItemPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='q']")
	WebElement item;
	
	@FindBy(how=How.XPATH, using="//button[@class='_2iLD__']")
	WebElement serachbutton;
	
	@FindBy(how=How.XPATH, using="//div[@class='JFPqaw']/span")
	WebElement closeButton;
	
	public void search(String searchvalue)
	{
		item.sendKeys(searchvalue);
	}
	
	public void closeLogin()
	{
		closeButton.click();
	}
	
	public void clickOnSearch()
	{
		serachbutton.click();
	}
	
	
	
}
