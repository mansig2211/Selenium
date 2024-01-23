package com.flipkart.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.flipkart.dataProvider.*;

public class dataProvider

{
	
	public int n;
	public static XSSFWorkbook workbook;
	public static XSSFSheet testCases, testSheet;
	public static Map<String, Integer> testCaseMapping;
	public static Map<String, Integer> testCasemap;
	public static ArrayList<String> arr;
	Object obj[][];
	
	@DataProvider
	public void data_provider() throws IOException
	{
		
		File file= new File("C:\\Users\\SRIJAN\\OneDrive\\flipkart.xlsx");
		FileInputStream fis= new FileInputStream(file);
		
		workbook = new XSSFWorkbook(fis);
		
			 testCases= workbook.getSheetAt(0);
			
			Row firstRow= testCases.getRow(0);
			
			n= testCases.getLastRowNum();
			
			 testCaseMapping = new HashMap<String, Integer>();
			 
			 
			 
			 
			// The below code creates a mapping for the driver sheet
			for (Cell cell: firstRow)
			{
				testCaseMapping.put(cell.getStringCellValue(), cell.getColumnIndex());
				
			}
			
			System.out.println(testCaseMapping);
			
				
}
}
				
		
		
		

