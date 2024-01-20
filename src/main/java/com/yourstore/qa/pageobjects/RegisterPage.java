package com.yourstore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourstore.qa.base.Base;
import com.yourstore.qa.utils.Utilities;

public class RegisterPage extends Base {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement telephoneTextField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	private WebElement noSubscribeRadioButton;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Y')]")
	private WebElement accountCreatedSuccessMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillUpRegisterForm() {
		firstNameTextField.sendKeys(dataProp.getProperty("firstName"));
		lastNameTextField.sendKeys(dataProp.getProperty("lastName"));
		emailTextField.sendKeys(Utilities.generateEmailWithTimeStamp());
		telephoneTextField.sendKeys(dataProp.getProperty("telephone"));
		passwordTextField.sendKeys(dataProp.getProperty("password"));
		confirmPasswordTextField.sendKeys(dataProp.getProperty("password"));
		noSubscribeRadioButton.click();
		privacyPolicyCheckbox.click();
		continueButton.click();
	}
	
	public boolean verifyAccountCreationSuccessMessage() {
		return accountCreatedSuccessMessage.isDisplayed();
	}

}
