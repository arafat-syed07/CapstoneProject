package com.cps.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cps.qa.base.TestBase;

import com.cps.qa.pages.LoginPage;
import com.cps.qa.pages.Account;

public class CustomerLoginTest extends TestBase {
	LoginPage loginPage;
	Account accountPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");

	public CustomerLoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		accountPage = new Account();

	}

	@Test(priority = 1)
	public void customerlogin() {
		loginPage.CustomerLogin(AccountexistUser);
		String name = accountPage.verifyCustomerName();
		Assert.assertEquals(AccountexistUser, name);

	}

	@Test(priority = 2)
	public void customerlogin_Not_Exist() {
		loginPage.CustomerLogin(AccountNot_existUser);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}