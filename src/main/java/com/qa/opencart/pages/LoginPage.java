package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver; // without this we can not get driver.methods in this class
	private ElementUtil eleUtil;
	
	// 1. private By locators: page objects
	private By logo = By.cssSelector("img.img-responsive");
	private By username = By.id("input-email");
	private By passowrd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// 2. Public Page Constructor..
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Methods
	public boolean isLogoExist() {
		return eleUtil.isElementDisplayed(logo);
	}
	
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login Page Title is: " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login Page URL is: " + url);
		return url;
	}

	public boolean isForgotPasswordLinkExist() {
		return eleUtil.isElementDisplayed(forgotPasswordLink);
	}
	
	public AccountsPage doLogin(String userName, String pwd) {
		
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(userName);
		eleUtil.doActionsSendKeys(passowrd, pwd);
		eleUtil.doClick(loginBtn);
		
		// Implementing Page chaining model /Zig Zag pattern
		return new AccountsPage(driver);

//		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
//		System.out.println("Accounts Page Title is: " + title);
//		return title;
	}
		
}
