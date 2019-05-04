package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'naveen')]")
	WebElement usernameLable;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	// initializing home page objects

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return usernameLable.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
	}

	public DealsPage clickOnDealsLink() {
		tasksLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();

	}
}