package com.yourstore.qa.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.yourstore.qa.base.Base;

public class Utilities extends Base {
	
	// Constants
	public static final int IMPLICIT_WAIT_TIME = 30;
	public static final int PAGE_LOAD_TIME = 20;
	
	public static String generateEmailWithTimeStamp() {
		String timestamp = LocalDateTime.now().toString().replaceAll("\\D", "_");
		return dataProp.getProperty("firstName") + timestamp + "@gmail.com";
	}
	
	public static String getStringTestDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\yourstore\\qa\\testdata\\YourStoreTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row rowData = sheet.getRow(row);
		Cell cellData = rowData.getCell(cell);
		String cellValue = cellData.getStringCellValue();
		return cellValue;
	}
	
	public static double getDoubleTestDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\yourstore\\qa\\testdata\\YourStoreTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row rowData = sheet.getRow(row);
		Cell cellData = rowData.getCell(cell);
		double cellValue = cellData.getNumericCellValue();
		return cellValue;
	}
	
	public static int getIntegerTestDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\yourstore\\qa\\testdata\\YourStoreTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row rowData = sheet.getRow(row);
		Cell cellData = rowData.getCell(cell);
		int cellValue = (int) cellData.getNumericCellValue();
		return cellValue;
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		// Temporary Screenshot
		File srcScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Permanent Screenshot
		String destinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots" + testName + ".png";
		
		try {
			FileUtils.copyFile(srcScreenShot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationScreenshotPath;
	}
	
}
