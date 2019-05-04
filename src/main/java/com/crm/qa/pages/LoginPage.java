package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// page factory - OR object repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']") //the element is unclickable error
	WebElement loginButton;

	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;

	// initialization of the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// actions

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	/*public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(loginButton));
		System.out.println(loginButton.getText());
		loginButton.click();
		return new HomePage();*/
	
	public HomePage login(String un, String pwd){

		username.sendKeys(un);

		password.sendKeys(pwd);

		//loginBtn.click();

		    	JavascriptExecutor js = (JavascriptExecutor)driver;

		    	js.executeScript("arguments[0].click();", loginButton);

		    	

		return new HomePage();
	}

}
