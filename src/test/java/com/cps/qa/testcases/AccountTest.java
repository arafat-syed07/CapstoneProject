package com.cps.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cps.qa.base.TestBase;
import com.cps.qa.pages.LoginPage;
import com.cps.qa.pages.Account;

public class AccountTest extends TestBase {
	LoginPage loginPage;
	Account accountPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
	int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount"));
	int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount"));
	String Successfull = prop.getProperty("Successfull");
	String inSufficient = prop.getProperty("inSufficient");
	int InSufficient_Amount = Integer.valueOf(prop.getProperty("InSufficient_Amount"));

	public AccountTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		accountPage = loginPage.CustomerLogin(AccountexistUser);
	}

	@Test(priority = 1)
	public void Verify_Deposit_With_ValideAmmount() {
		accountPage.ValidDeposit("Deposit Successful", ValidAmount);
	}

	@Test(priority = 2)
	public void Verify_Deposit_With_InValideAmmount() {
		accountPage.InValidDeposit(InValidAmount);
	}

	@Test(priority = 3)
	public void Verify_Withdraw_With_ValideAmmount() throws InterruptedException {
		accountPage.ValidWithdraw(Successfull, ValidAmount);
	}

	@Test(priority = 4)
	public void Verify_Withdraw_With_InValideAmmount() throws InterruptedException {
		accountPage.InValidWithdraw(InValidAmount);
	}

	@Test(priority = 5)
	public void Verify_Withdraw_With_InSufficient() throws InterruptedException {
		accountPage.ValidWithdraw(inSufficient, InSufficient_Amount);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}