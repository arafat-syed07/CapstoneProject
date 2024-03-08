package com.cps.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cps.qa.base.TestBase;

public class Customers extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
	public WebElement Customer_button;

	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	WebElement SearchBox;

	@FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
	WebElement Delete;

	// Initializing the Page Objects:
	public Customers() {
		PageFactory.initElements(driver, this);
	}

	public void DeleteEntry(String username) throws InterruptedException {
		Customer_button.click();
		SearchBox.sendKeys(username);
		Delete.click();
		System.out.println("DEleted customers details successfully");

	}

}
