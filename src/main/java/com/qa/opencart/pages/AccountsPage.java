package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.id("div#search content");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE,
				AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Accounts Page Title is: " + title);
		return title;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(logoutLink);
	}

	public int getTotalAccountPageHeaders() { 
		List<WebElement> headersList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_SHORT_TIME_OUT);
		int headersCount =  headersList.size();
		return headersCount;
	}

	public List<String> getAccountPageHeaders() {
		List<WebElement> headersList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_SHORT_TIME_OUT);
		List<String> headersValueList = new ArrayList<String>();
		for (WebElement e : headersList) {
			String headerText = e.getText();
			headersValueList.add(headerText);
		}
		return headersValueList;
	}

	public void doSearch(String searchKey) {
		eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
	}
}
