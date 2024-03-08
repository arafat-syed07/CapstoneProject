package com.cps.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cps.qa.base.TestBase;

import com.cps.qa.pages.LoginPage;
import com.cps.qa.pages.OpenAccount;
import com.cps.qa.pages.Account;
import com.cps.qa.pages.AddCustomer;
import com.cps.qa.pages.Customers;

public class CustomersTest extends TestBase {
	LoginPage loginPage;
	Customers customersPage;
	String Customers_username = prop.getProperty("Customers_username");

	public CustomersTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		customersPage = loginPage.ManagerLogin2();
	}

	@Test(priority = 1)
	public void DeleteCustomerEntry() throws InterruptedException {
		customersPage.DeleteEntry(Customers_username);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}