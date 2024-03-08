package com.cps.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cps.qa.base.TestBase;
import com.cps.qa.pages.LoginPage;
import com.cps.qa.pages.OpenAccount;

public class OpenAccountTest extends TestBase {
	LoginPage loginPage;
	OpenAccount openAccountPage;
	String OpenAccount_username = prop.getProperty("OpenAccount_username");

	public OpenAccountTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		openAccountPage = loginPage.ManagerLogin1();

	}

	@Test(priority = 1)
	public void OpenAccount() throws InterruptedException {
		openAccountPage.OpenAccount_button.click();
		openAccountPage.AddCustomer(OpenAccount_username);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
