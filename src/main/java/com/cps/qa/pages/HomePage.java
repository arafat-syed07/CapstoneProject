package com.cps.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cps.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebDriver driver;

	@FindBy(xpath = "//button[normalize-space()='Customer Login']")
	WebElement Customer_Login;

	@FindBy(linkText = "Bank Manager Login")
	WebElement Manager_Login;

	@FindBy(xpath = "//span[@class='title']")
	WebElement HomePageValidation;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectPage() {
		return HomePageValidation.isDisplayed();
	}

	public void clickOnNewContactLink() {
		// TODO Auto-generated method stub

	}

	public void ManagerLogin() {
		// TODO Auto-generated method stub
		Manager_Login.click();
	}

}
