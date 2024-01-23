import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import baseClass.baseClassSetup;

@Test
public class Robot_class_demo 
{
	WebDriver driver;
	public void uploadFile() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//driver =new ChromeDriver();
		 ChromeOptions ops = new ChromeOptions();
		 ops.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver();
		
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		Thread.sleep(2000);
		driver.findElement(By.id("uploader")).click();
		
		Robot robot= new Robot();
		for(int i=1;i<=9;i++)
			{
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	for(int i=1;i<=3;i++)
	{
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	String doc="Dear Dadaji.";
	int l= doc.length();
	char arr[]= new char[l];
	for(int i=0;i<l;i++)
	{
		arr[i]=doc.charAt(i);
	}
	
	for(int i=0;i<l;i++)
	{
		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(doc.charAt(i)));
		robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(doc.charAt(i)));
	}
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	
}
}