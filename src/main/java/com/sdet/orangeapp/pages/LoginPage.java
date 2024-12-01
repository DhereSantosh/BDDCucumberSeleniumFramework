package com.sdet.orangeapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	//by locators
	private By Username = By.xpath("//input[@placeholder='Username']");
	private By Password = By.xpath("//input[@placeholder='Password']");
	private By LoginBtn = By.xpath("//button[normalize-space()='Login']");
	private By userdropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By ForgotPwdLinkLocator = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Page Methods
	public void enterUsername(String uname) {
		WebElement username = driver.findElement(Username);
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pword) {
		WebElement password = driver.findElement(Password);
		password.sendKeys(pword);
	}
	
	public void clickOnLoginBtn() {
		WebElement password = driver.findElement(LoginBtn);
		password.click();
	}
	
	public void clickForgottenPwdLink() throws InterruptedException {
		WebElement forgottenPasswordLink = driver.findElement(ForgotPwdLinkLocator);
		Thread.sleep(500);
		forgottenPasswordLink.click();
	}
	
	public boolean checkForgottenPwdLink() throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(ForgotPwdLinkLocator).isDisplayed();
		
	}
	
	public boolean checkUserdropdown() throws InterruptedException {
		Thread.sleep(1200);
		return driver.findElement(userdropdown).isDisplayed();
	}
	
	public void login(String username,String password) throws InterruptedException {
		Thread.sleep(1000);
		enterUsername(username);
		enterPassword(password);
		Thread.sleep(200);
		clickOnLoginBtn();
	}
	
	public String getForgotPwdPageUrl() {
		String forgotPwdPageUrl = driver.getCurrentUrl();
		return forgotPwdPageUrl;
	}
	

}
