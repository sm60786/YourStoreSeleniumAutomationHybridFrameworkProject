package com.yourstore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourstore.qa.base.Base;

public class LoginPage extends Base {
	
	WebDriver driver;
	
	// Page Objects
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTextField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//div[contains(text(), ' W')]")
	private WebElement warningMessageForWrongUsernamePassword;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public void enterEmailAddress(String username) {
		emailTextField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void verifyLoginWithValidCredential(String username, String password) {
		enterEmailAddress(username);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public String verifyWarningTextForWrongUsernamePassword() {
		String warningText = warningMessageForWrongUsernamePassword.getText();
		return warningText;
	}

}
