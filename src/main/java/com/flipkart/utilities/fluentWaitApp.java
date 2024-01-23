package com.flipkart.utilities;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClassSetup;
public class fluentWaitApp 

{
	
	WebDriver driver;

	public void hault(String browser, WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver=driver;
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebElement error=driver.findElement(By.className("title-text"));
			if(error.getText().toString().equals("Hmm. We’re having trouble finding that site."))
			{
				System.out.println("In wait");
				 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(30)).ignoring(WebDriverException.class);
				 WebElement ele= wait.until(new Function<WebDriver, WebElement>(){
					 public WebElement apply(WebDriver driver) {
						 driver.navigate().refresh();
						 return driver.findElement(By.xpath("//input[@name='q']"));
						 
					 }
					 
				 });
				 
				 
			
			}
		}
		else if(browser.equalsIgnoreCase("chrome"))
				{
			WebElement error=driver.findElement(By.className("error-code"));
			if(error.getText().toString().equals("ERR_INTERNET_DISCONNECTED"))
			{
				System.out.println("In wait");
				 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(30)).ignoring(WebDriverException.class);
				 WebElement ele= wait.until(new Function<WebDriver, WebElement>(){
					 public WebElement apply(WebDriver driver) {
						 driver.navigate().refresh();
						 return driver.findElement(By.xpath("//input[@name='q']"));
						 
					 }
					 
				 });
			
			
				}
		
	}

	
}
}
