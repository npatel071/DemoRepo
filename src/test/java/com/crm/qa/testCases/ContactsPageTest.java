package com.crm.qa.testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	TestUtil testUtil;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLable;

	public ContactsPageTest() {
		super(); // this is will load properties file
	}

	@BeforeTest
	public void setUp() {
		initialization();
		homePage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLableTest() {
		Assert.assertTrue(contactsPage.verifyContactsLable());
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContacts("test2 test2");

	}
	
	@DataProvider
	public void getTestData(){
		
	}
	@Test(priority=4)
	public void validateCreateNewContact(){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Geroge", "Washington", "Apple");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
