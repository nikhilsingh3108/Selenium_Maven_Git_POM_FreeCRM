package com.freecrm.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.Base.Base;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;

public class LoginTestCase extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
		loginpage.FirstPageLogin();
	}
	
	@Test
	public void LoginCase() {
		homepage = loginpage.LoginpageTest();
			}
	
	@Test(dependsOnMethods="LoginCase")
	public void CheckHomePage()
	{
		String title = loginpage.ValidateHomePage();
		Assert.assertEquals(title, "CRM");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
