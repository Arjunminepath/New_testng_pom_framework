package com.Demowebshopqa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 10;
	public static String gettimestamp()
	{
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
				
	}
	
	public static Object[][] getTestdataFromExcel(String sheetname) throws IOException
	{
		
		File excelfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Demowebshopqa\\testdata\\DemowebshopTestData.xlsx");
		XSSFWorkbook workbook = null;
		try
		{
			FileInputStream fisexcel =new FileInputStream(excelfile);
			workbook = new XSSFWorkbook(fisexcel);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetname);
		 
		 int rows=sheet.getLastRowNum();
		 int cols=sheet.getRow(0).getLastCellNum();
		 
		 Object[][] data = new Object[rows][cols];
		 
		 for(int i=0;i<rows;i++)
		 {
			 XSSFRow row = sheet.getRow(i+1);
			 
			 for(int j=0;j<cols;j++)
			 {
				 XSSFCell cell = row.getCell(j);
				 CellType celltype=cell.getCellType();
				 
				 switch(celltype)
				 {
				 case STRING:
					 data[i][j]=cell.getStringCellValue();
					 break;
				 case NUMERIC:
					 data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					 break;
				 case BOOLEAN:
					 data[i][j]=cell.getBooleanCellValue();
				 }
			 }
		 }
		 return data;
		 
	}
	public static String capturescreenshot(WebDriver driver,String testname)
	{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir")+"\\screenshots\\"+testname+".png";
		try {
			FileHandler.copy(screenshot, new File(destinationpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationpath;
	}
}
