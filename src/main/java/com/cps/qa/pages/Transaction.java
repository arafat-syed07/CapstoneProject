package com.cps.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cps.qa.base.TestBase;

public class Transaction extends TestBase{
	
	WebDriver driver;
	
	//Page Factory - OR:
	@FindBy(xpath="//button[normalize-space()='Transactions']")
	WebElement Transaction_button;
	
	@FindBy(xpath="//input[@id='start']")
	WebElement StartDate;
	
	@FindBy(xpath="//input[@id='end']")
	WebElement EndDate;
	
	 
	@FindBy(xpath="//*[@id=\"anchor0\"]/td[1]")
	WebElement Validation;
	
	@FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]")
	    WebElement pageclick;
	
	
	//Initializing the Page Objects:
	public Transaction(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void Filter(String startDate, String endDate)
	{
		Transaction_button.click();
		StartDate.sendKeys(startDate);
		EndDate.sendKeys(endDate);
		pageclick.click();
		 
		
	}
}