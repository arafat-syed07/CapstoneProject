package com.cps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cps.qa.base.TestBase;

public class BankManagerLogin extends TestBase {
	WebDriver driver;

	
	//Page Factory - OR:
	@FindBy(xpath="//button[normalize-space()='Customer Login']")
	WebElement Customer_Login;
	
	@FindBy(linkText="Bank Manager Login")
	WebElement Manager_Login;

	//public String addCustomerButton;
	
	//Initializing the Page Objects:
	public BankManagerLogin(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void CustomerLogin(String username)
	{
		Customer_Login.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");
        
        driver.findElement(By.xpath(path)).click();
       
		
	}
	public void ManagerLogin()
	{
		Manager_Login.click();
	}

	public void addCustomerButton() {
		Customer_Login.click();
		
	}
	
}
