package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	TestUtil testUtil = new TestUtil();
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
	}

	// testcases should be independent
	// before every test case launch the browser and login
	// after every test case close the browser

	@Test(priority = 1)

	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "HomePage title not matched");
	}

	@Test(priority = 2)
	public void verifyCorrectUserameLable() {
		testUtil.switchToFrame();
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}