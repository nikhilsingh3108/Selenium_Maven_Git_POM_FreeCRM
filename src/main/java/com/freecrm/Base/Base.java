package com.freecrm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static Properties prop;
	public static FileInputStream fs;
	public static WebDriver driver;
	
	public Base(){
		prop = new Properties();
		try {
			fs = new FileInputStream("C:\\Users\\User\\Desktop\\Eclipse_Projects\\Selenium_Maven_Git_POM_FreeCRM_Test\\src\\main\\java\\com\\freecrm\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\downloads_AllinOne\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	}
	
	

}
