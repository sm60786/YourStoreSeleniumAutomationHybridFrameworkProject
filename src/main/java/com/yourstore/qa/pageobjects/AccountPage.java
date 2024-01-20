package com.yourstore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourstore.qa.base.Base;

public class AccountPage extends Base {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), 'Edit y')]")
	WebElement editAccountInformationOption;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDisplayStatusOfEditAccountInformationOption() {
		return editAccountInformationOption.isDisplayed();
	}

}
