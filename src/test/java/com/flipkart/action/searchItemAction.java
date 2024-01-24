package com.flipkart.action;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.testng.annotations.*;
import com.flipkart.pages.*;
import baseClass.baseClassSetup;
import extentReportPack.reportEx;
import junit.extensions.RepeatedTest;

import com.flipkart.utilities.*;
import com.aventstack.extentreports.ExtentTest;
import com.flipkart.dataProvider.*;
public class searchItemAction extends baseClassSetup
{
	
	 searchItemPage searchItem;
	 flipkartActionClass action;
	 public static reportEx rep;
	 public static ExtentTest test;
	 int testCaseNo=0;
	 static ArrayList<String> searchItemNames;
	 static ArrayList<String> testCaseNames;
	 //Map<String, Integer> arr;
	 Object obj[][];
	 int testCount=0;
	 
	 
	 @BeforeSuite
	 public static void createReport()
	 {
		 rep=new reportEx();// created an object of the report class
		 rep.report();
			
	 }
	 
	 @BeforeMethod
	 public void createTestReport() throws IOException
	 {
		 test= rep.extent.createTest(testCaseNames.get(testCount));
		 System.out.println("In before Method");
		 setup(test);
		 testCount++;
		
	 }
	 
	 @DataProvider
	public  Object[][] flipkartSearchDP() throws IOException
	{
		 	dataProvider dp= new dataProvider();
		 	
		 	dp.data_provider();
		 	
		 	XSSFSheet testSheet= dataProvider.workbook.getSheet("Search An Item");//sheet for searching items
		 	
		 	searchItemNames= new ArrayList<>();// to store all the items to be searched
		 	testCaseNames= new ArrayList<>();// to store all the test cases to be implemented
		 	
		 	//the below code creates a mapping for the test case sheet
		 	Map<String,Integer> testCasemap= new HashMap<>();
			
		 	Row row1= testSheet.getRow(0);
			
			
			for(Cell cell: row1)
			{
				testCasemap.put(cell.getStringCellValue(), cell.getColumnIndex());
				
			}
			
		
			for(int i=1;i<=dp.n;i++)
			{
				Row row= dataProvider.testCases.getRow(i);
				
				String testCaseName= row.getCell(dp.testCaseMapping.get("Test Case Name")).toString();
				
				if((row.getCell(dp.testCaseMapping.get("Run"))).toString().equalsIgnoreCase("yes")&& testCaseName.equalsIgnoreCase("Search An Item"))
				{
					String testCaseDesc= row.getCell(dp.testCaseMapping.get("Test Case Desciption")).toString();
					
					int noOfRowsInTestDataSheet= testSheet.getLastRowNum();
					
					for(int j=1;j<=noOfRowsInTestDataSheet;j++)
					{
						Row currentRow= testSheet.getRow(j);					
						if(currentRow.getCell(testCasemap.get("Test Case Desciption")).toString().equalsIgnoreCase(testCaseDesc))
						{
							searchItemNames.add(currentRow.getCell(testCasemap.get("Item")).toString());
							testCaseNames.add(currentRow.getCell(testCasemap.get("Test Case Desciption")).toString());
							testCaseNo++;
							break;
						}
						
					}
					
				}
				
				
			}
			
			obj= new Object[testCaseNo][1];
			for(int i=0;i<testCaseNo;i++)
			{
				obj[i][0]=searchItemNames.get(i);
			}
			return obj;
	}
	
	
	
	//@Test(dataProvider="data_provider", dataProviderClass=dataProvider.class)
	 
	 @Test(dataProvider="flipkartSearchDP")
	public void searchAnItem(String item) throws IOException, InterruptedException
	{
		
		
		action= new flipkartActionClass();
		searchItem= new searchItemPage(driver);
		
		
				Thread.sleep(6000);
				
				searchItem.closeLogin();
				test.info("Closed the login popup");
				
				Thread.sleep(2000);
				
				searchItem.search("fruit");
				test.pass("Searched for " +item);
				
				searchItem.clickOnSearch();
				test.pass("Clicked on search");
				
				Thread.sleep(5000);
				
		
		
		
		
		
		
	}
	
	
	@Test(enabled=false)
	public static void test2() throws IOException
	{
		
		
		String ti= driver.getTitle();
		
			test.pass("passed");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		rep.extent.flush();
		
	}

	@AfterSuite
	public void afterTest() throws IOException
	{
		Desktop.getDesktop().browse(new File("rep.html").toURI());
		
	}
}
