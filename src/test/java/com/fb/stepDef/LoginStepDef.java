package com.fb.stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fb.utility.DriverManager;
import com.sun.tools.javac.util.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {
	//Web Elements
	private final By userName = By.cssSelector("[data-testid='royal_email']");
	private final By password = By.cssSelector("[data-testid='royal_pass']");
	private final By loginBtn = By.cssSelector("[data-testid='royal_login_button']");
	
	//WebDriver
	public static WebDriver driver = null;
	

	@Given("^open the browser and launch the \"([^\"]*)\"$")
	public void open_the_browser_and_launch_the(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			DriverManager driverObj = new DriverManager();
			driver = driverObj.initiateWebDriver();
			driver.get(arg1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Then("^verify home page title \"([^\"]*)\"$")
	public void verify_home_page_title(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
try {
    // Hard coded the expected parameter to avoid the special character issue '-'
	junit.framework.Assert.assertEquals("Facebook – log in or sign up",driver.getTitle());
	System.out.println("Application Launced successfully");
	}catch(Exception e) {
		System.out.println(e);
		driver.quit();
	}
}


	@When("^Page loaded successfully enter a valid \"([^\"]*)\" and a invalid password \"([^\"]*)\"$")
	public void page_loaded_successfully_enter_invalid_an_password(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			//Clear and send userName to the password field
			 driver.findElement(userName).click();
             driver.findElement(userName).sendKeys(arg1);
             //Clear and send password to the password field
             driver.findElement(password).clear();
             driver.findElement(password).sendKeys(arg1);
 			System.out.println("UserName and Password Entered successfully");

		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
		}
	}

	@When("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			//click on the login button
			driver.findElement(loginBtn).click();
		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
		}
	}

	@Then("^verify the unsuccessful login page title \"([^\"]*)\" and password error message \"([^\"]*)\"$")
	public void verify_the_unsuccessful_login_page_title_and_password_error_message(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			//Assert the unsucessful login page
			junit.framework.Assert.assertEquals("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110", driver.getCurrentUrl());
			//Hard coded the expected parameter to avoid the special character issue '|'
			junit.framework.Assert.assertEquals(arg1, driver.getTitle());
 			System.out.println("Unsuccessfully Login page displayed successfully");
 			//validate password tip message
 			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 			String passToolTip = driver.findElement(By.xpath("//div[@id='globalContainer' and contains(@class, 'uiContextualLayerParent')]/div[contains(@class, 'uiContextualLayerPositioner')]/div[contains(@class, 'uiContextualLayer')]/div[contains(@class, '_5v-0')]/div[contains(@class, '_4rbf')]")).getText();
			junit.framework.Assert.assertEquals(arg2, passToolTip);	
 			System.out.println("Verified the error message");

		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
		}
	}
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
           try {
        	   driver.quit();
           }catch(Exception e) {
        	   System.out.println(e);
        	   driver.quit();
           }
	}
}
