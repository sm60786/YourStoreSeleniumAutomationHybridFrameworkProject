package com.yourstore.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourstore.qa.base.Base;
import com.yourstore.qa.pageobjects.HomePage;
import com.yourstore.qa.pageobjects.RegisterPage;

public class RegisterTest extends Base {
	
	HomePage homePage;
	RegisterPage registerPage;
	public WebDriver driver;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = -1)
	public void verifyRegisteringAnAccountWithMandatoryFields()  {
		registerPage.fillUpRegisterForm();
		Assert.assertTrue(registerPage.verifyAccountCreationSuccessMessage());
	}
	
}
