package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test
	public void forgotPasswordLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Test
	public void logoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}
	
	@Test(priority = Integer.MAX_VALUE)	
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}

}
