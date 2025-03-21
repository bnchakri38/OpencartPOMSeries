package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accountsPageTitleTest() {
		String actualTitle = accountsPage.getAccountsPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}
	
	@Test
	public void accountsPageHeadersCountTest() {
		Assert.assertEquals(accountsPage.getTotalAccountPageHeaders(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void accountsPageHeadersTest() {
		List<String> actaulHeadersList = accountsPage.getAccountPageHeaders();
		Assert.assertEquals(actaulHeadersList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	}
	
	
}
