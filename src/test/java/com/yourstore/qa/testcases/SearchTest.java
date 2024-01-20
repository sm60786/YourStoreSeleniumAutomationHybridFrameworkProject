package com.yourstore.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourstore.qa.base.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = -3)
	public void verifySearchWithValidProduct() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("validProductName"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
	}
	
	@Test(priority = -2)
	public void verifySearchWithInvalidProduct() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("invalidProductName"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String expectedMessage = dataProp.getProperty("searchWithInvalidProductMessage");
		String actualMessage = driver.findElement(By.xpath("//p[contains(text(), 'T')]")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(priority = -1)
	public void verifySearchWithNoProduct() {
		driver.findElement(By.xpath("//div[@id='search']/child::input")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/child::span")).click();
		String expectedMessage = dataProp.getProperty("searchWithNoProduct");
		String actualMessage = driver.findElement(By.xpath("//p[contains(text(), 'T')]")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
}
