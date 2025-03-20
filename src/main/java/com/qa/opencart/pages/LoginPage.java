package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver; // without this we can not get driver.methods in this class

	// 1. private By locators: page objects
	private By logo = By.cssSelector("img.img-responsive");
	private By firstname = By.id("input-email");
	private By passowrd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// 2. Public Page Constructor..
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Public Page Actions/Methods
	public boolean isLogoExist() {
		return driver.findElement(logo).isDisplayed();
	}
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Page title is: " + url);
		return url;
	}

	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public String doLogin(String userName, String pwd) {
		driver.findElement(firstname).sendKeys(userName);
		driver.findElement(passowrd).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return getLoginPageTitle();
	}
		
}
