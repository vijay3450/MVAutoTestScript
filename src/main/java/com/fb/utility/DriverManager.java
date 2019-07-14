package com.fb.utility;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	WebDriver driver = null;
	
	public WebDriver initiateWebDriver() {
		 String path = Paths.get("").toAbsolutePath().toString();
	        
			System.setProperty("webdriver.chrome.driver", ""+path+"//drivers//chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();
			
			return driver;
	}

}
