package com.cps.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cps.qa.base.TestBase;

public class CustomerLogin extends TestBase {

	WebDriver driver;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg']")
	WebElement customerloginbutton;
	@FindBy(xpath = "//option[@value='21']")
	WebElement namefrdropdown;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath = "//div[@class='ng-scope']")
	WebElement nextpage;

	// Initializing the Page Objects:
	public CustomerLogin() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

}
