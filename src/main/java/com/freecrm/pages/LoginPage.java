package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.Base.Base;

public class LoginPage extends Base {
	
@FindBy(xpath="//a/child::span[contains(text(),'Log In')]")
WebElement  Loginbtn;

@FindBy(xpath="//a[@class='brand-name' and @title='free crm home']")
WebElement brandName;

@FindBy(xpath="//input[@name='email']")
WebElement username;

@FindBy(xpath="//input[@name='password']")
WebElement password;

@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
WebElement LogggedIn;

public LoginPage() {
	PageFactory.initElements(driver, this);
}

public HomePage LoginpageTest() {
	username.sendKeys(prop.getProperty("username"));
	password.sendKeys(prop.getProperty("password"));
	LogggedIn.click();
	
	return new HomePage();
}

public void FirstPageLogin() {
	Loginbtn.click();
}

public String ValidateHomePage() {
	return driver.getTitle();
	}

}
