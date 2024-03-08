package com.cps.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.cps.qa.util.TestUtil;
import com.cps.qa.util.WebEventListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("C:\\Users\\Syed Arfaat\\eclipse-workspace\\BankCapstoneProject\\src\\main\\java\\com\\cps\\qa\\configration"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.firefox.driver",
					"C:\\Users\\Syed Arfaat\\Downloads\\Manipal\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("edge")){
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Syed Arfaat\\Downloads\\Manipal\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();  
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListner();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}