package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLable;

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "surname")
	WebElement lastname;

	@FindBy(name = "client_lookup")
	WebElement companyname;

	@FindBy(xpath = "//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement saveButton;

	// initialization of page objects

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLable() {
		return contactsLable.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'test2 test2')]"
				+ "//parent::td//preceding-sibling::td/input[@name='contact_id' and @type='checkbox']")).click();

	}

	public void createNewContact(String title, String fname, String lname, String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		companyname.sendKeys(company);
		saveButton.click();
	}

}
