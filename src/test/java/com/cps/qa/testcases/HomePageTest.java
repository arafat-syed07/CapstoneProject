package com.cps.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cps.qa.base.TestBase;
import com.cps.qa.pages.HomePage;
import com.cps.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	// LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		// omePage = loginPage.login1(prop.getProperty("username"),
		// prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "XYZ Bank");
	}

	@Test(priority = 2)
	public void verifyHomePage() {
		boolean HomePage = homePage.verifyCorrectPage();
		Assert.assertTrue(HomePage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
