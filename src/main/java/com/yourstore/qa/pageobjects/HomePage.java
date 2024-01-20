package com.yourstore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourstore.qa.base.Base;

public class HomePage extends Base {
	
	WebDriver driver;
	
	// Page Objects
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccountDropdownMenu;
	
	@FindBy(xpath = "//a[text()='Login']") 
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[text()='Login']/../preceding-sibling::li/a[text()='Register']")
	private WebElement registerLink;
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public RegisterPage goToRegisterPage() {
		myAccountDropdownMenu.click();
		registerLink.click();
		return new RegisterPage(driver);
	}
	
	public LoginPage goToLoginPage() {
		myAccountDropdownMenu.click();
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public boolean verifyMyAccountLinkIsPresent() {
		return myAccountDropdownMenu.isDisplayed();
	}
	
}
