package com.cps.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.cps.qa.base.TestBase;

public class Deposit extends TestBase {
	
	WebDriver driver;
	
	@FindBy(id="accountSelect")
	WebElement account;
	
	@FindBy(xpath="//button[@ng-click='deposit()']")
	WebElement depositbutton;
	@FindBy(xpath="//input[@placeholder='amount']")
	WebElement emptyfield;
	@FindBy(xpath="//label[text()='Amount to be Deposited :']")
	WebElement head;
	@FindBy(xpath="//input[@ng-model='amount']")
	WebElement amount;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//span[@ng-show='message']")
	WebElement msg;
	
	public Deposit() {
		PageFactory.initElements(driver, this);
	}
	
	public void validinvalidDeposit() {
		String accno=account.getText();
		Assert.assertEquals(accno, "1016");
		System.out.println("Valid Account Number");
		//for invalid data
		depositbutton.click();
		Assert.assertTrue(emptyfield.isDisplayed());
		String errormsg=emptyfield.getText();
		System.out.println(errormsg);
		//valid data
		depositbutton.click();
		Assert.assertTrue(head.isDisplayed());
		System.out.println("User On deposit page");
		String am=prop.getProperty("amountdeposit");
		amount.sendKeys(am);
		System.out.println("Amount Added");
		submit.click();
		Assert.assertTrue(msg.isDisplayed());
		String text=msg.getText();
		System.out.println("User get message: "+text);
		
	}

}

