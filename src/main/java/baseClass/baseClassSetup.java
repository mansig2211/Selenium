package baseClass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import extentReportPack.reportEx;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.flipkart.utilities.fluentWaitApp;

public class baseClassSetup
{
	public static WebDriver driver;
	
	
	public static void setup(ExtentTest rep) throws IOException
	
	{
		String browser= "chrome";
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "C:\\Selenium\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		
		else
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				//driver =new ChromeDriver();
				 ChromeOptions ops = new ChromeOptions();
				 ops.addArguments("--remote-allow-origins=*");
				driver= new ChromeDriver();
				
			}
		
		
		
		try {
		driver.get("https://www.flipkart.com/");
			//driver.get("https://www.ilovepdf.com/word_to_pdf");
		Thread.sleep(2000);
		rep.pass("Opened the URL");
		
		driver.manage().window().maximize();
		rep.pass("Maximized the window");
		
		
		}
		catch(Exception WebDriverException)
		{
			//rep.fail(WebDriverException);
			fluentWaitApp wait= new fluentWaitApp();
			rep.info("Waiting for another 30 seconds");
			try
			{
			wait.hault(browser, driver);}
			catch(Exception SocketException)
			{
				rep.fail(SocketException);
				driver.close();
			}
			
		}
		
		
		
		
		
	}
	
	public static String takescrsht()
	{
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		//return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		
		
	}

}
