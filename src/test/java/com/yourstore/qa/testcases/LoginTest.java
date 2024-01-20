package com.yourstore.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yourstore.qa.base.Base;
import com.yourstore.qa.pageobjects.AccountPage;
import com.yourstore.qa.pageobjects.HomePage;
import com.yourstore.qa.pageobjects.LoginPage;
import com.yourstore.qa.utils.Utilities;

public class LoginTest extends Base {
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
//	@DataProvider
//	public Object[][] supplyTestData() {
//		Object[][] data = {
//				{"Sibaram2024_01_18_18_26_38_519690500@gmail.com", "Menoob@123"},
//				{"Sibaram2024_01_19_15_17_22_485488100@gmail.com", "1234567890"}
//				};
//		return data;
//	}
	
	@Test(priority = -3) 
	public void checkMyAccountOption() {
		Assert.assertTrue(homePage.verifyMyAccountLinkIsPresent());
	}
	
	@Test(priority = -2)
	public void verifyLoginWithValidCreds_1() {
		accountPage = new AccountPage(driver);
		String sheetName = dataProp.getProperty("sheetName");
		String username;
		String password;
		try {
			username = Utilities.getStringTestDataFromExcel(sheetName, 1, 0);
			password = Utilities.getStringTestDataFromExcel(sheetName, 1, 1);
			loginPage.verifyLoginWithValidCredential(username, password);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(accountPage.getDisplayStatusOfEditAccountInformationOption());
	}
	
	
//	@Test(priority = -1)
//	public void verifyLoginWithValidCredentials_2nd() {
//		accountPage = new AccountPage(driver);
//		String sheetName = dataProp.getProperty("sheetName");
//		String username;
//		String password;
//		try {
//			username = Utilities.getStringTestDataFromExcel(sheetName, 2, 0);
//			password = Utilities.getStringTestDataFromExcel(sheetName, 2, 1);
//			loginPage.verifyLoginWithValidCredential(username, password);
//		} catch (EncryptedDocumentException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue(accountPage.getDisplayStatusOfEditAccountInformationOption());
//	}
	
	@Test(priority = 0)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("password"));
		loginPage.clickOnLoginButton();
		String warning = loginPage.verifyWarningTextForWrongUsernamePassword();
		Assert.assertEquals(warning, dataProp.getProperty("expectedWarningMessageForWrongCredentials"));
	}
	
}
