package com.cps.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.cps.qa.base.TestBase;

public class Withdrawl extends TestBase {
	
	@FindBy(xpath="//button[@ng-click='withdrawl()']")
	WebElement withdrawlbutton;
	@FindBy(xpath="//input[@type='number']")
	WebElement withdrawamount;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	

}