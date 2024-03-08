package com.cps.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cps.qa.base.TestBase;
import com.cps.qa.pages.LoginPage;
import com.cps.qa.pages.Account;
import com.cps.qa.pages.Transaction;

public class TransactionTest extends TestBase {
	LoginPage loginPage;
	Transaction customerTransactionPage;

	String date = prop.getProperty("ValidationDate");
	String Startdate = prop.getProperty("StartDate");
	String Enddate = prop.getProperty("EndDate");

	String AccountexistUser = prop.getProperty("AccontExistUser");

	public TransactionTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		customerTransactionPage = loginPage.CustomerLogin1(AccountexistUser);

	}

	@Test(priority = 1)
	public void Verify_Deposit_With_ValideAmmount() {
		customerTransactionPage.Filter(Startdate, Enddate);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
