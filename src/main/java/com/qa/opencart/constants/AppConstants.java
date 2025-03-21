package com.qa.opencart.constants;

import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_LONG_TIME_OUT = 20;
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	
	public static final int ACCOUNTS_PAGE_HEADERS_COUNT = 4;
	public static final List<String> EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST = List.of("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	public static final String LOGIN_PAGE_FULL_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	
}
