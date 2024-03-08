package com.cps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cps.qa.base.TestBase;

public class LoginPage extends TestBase {

	WebDriver driver;

	// Page Factory - OR:
	@FindBy(xpath = "//button[normalize-space()='Customer Login']")
	WebElement Customer_Login;

	@FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
	WebElement Manager_Login;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public Account CustomerLogin(String username) {
		Customer_Login.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

		// Create a Select object
		Select dropdown = new Select(dropdownElement);

		// Select an option by visible text
		dropdown.selectByVisibleText(username);
		String path = prop.getProperty("Login");

		driver.findElement(By.xpath(path)).click();

		return new Account();

	}

	public Transaction CustomerLogin1(String username) {
		Customer_Login.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

		// Create a Select object
		Select dropdown = new Select(dropdownElement);

		// Select an option by visible text
		dropdown.selectByVisibleText(username);
		String path = prop.getProperty("Login");

		driver.findElement(By.xpath(path)).click();

		return new Transaction();

	}

	public AddCustomer ManagerLogin() {
		Manager_Login.click();
		return new AddCustomer();
	}

	public OpenAccount ManagerLogin1() {
		Manager_Login.click();
		return new OpenAccount();
	}

	public Customers ManagerLogin2() {
		Manager_Login.click();
		return new Customers();
	}

}
