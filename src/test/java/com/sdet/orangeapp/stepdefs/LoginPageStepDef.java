package com.sdet.orangeapp.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.sdet.orangeapp.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(500);
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Given("I am on the OrangeHRM login page")
	public void i_am_on_the_orange_hrm_login_page() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		loginPage = new LoginPage(driver);
	}	
		//24.43 https://www.youtube.com/watch?v=dwcRdXB_39k
		
	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() throws InterruptedException {
		Thread.sleep(1000);
		loginPage.enterUsername("Admin");
		Thread.sleep(600);
		loginPage.enterPassword("admin123");
		
	}
	
	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		loginPage.enterUsername(username);
		Thread.sleep(600);
		loginPage.enterPassword(password);
	}

	
	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
		Thread.sleep(100);
		loginPage.clickOnLoginBtn();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals(loginPage.checkUserdropdown(), true);
	}


	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String string) throws InterruptedException {
		Thread.sleep(1200);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']")).isDisplayed(), true);
	}

	@When("I click on the \"Forgotten Password\" link")
	public void i_click_on_the_forgotten_password_link() throws InterruptedException {
		Thread.sleep(100);
		loginPage.clickForgottenPwdLink();
	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() throws InterruptedException {	
		Thread.sleep(100);
		Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("requestPasswordResetCode"));
	}	
	 
}
