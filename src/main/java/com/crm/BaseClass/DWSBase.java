package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.ReadFromProperties1;
import com.crm.pom.DwsLogin;

public class DWSBase {

	public static WebDriver driver=null;
	@BeforeClass 
	public void preCondition() throws IOException {
		String browser=ReadFromProperties1.getData("browser");
		String url=ReadFromProperties1.getData("url");
		if(browser.equalsIgnoreCase(browser))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		else {
			driver =new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	@BeforeMethod 
	public void login() throws IOException {
		String username=ReadFromProperties1.getData("username");
		String password=ReadFromProperties1.getData("password");
		DwsLogin dws_lgn=new DwsLogin(driver);
		dws_lgn.loginLink();
		dws_lgn.userName(username);
		dws_lgn.password(password);
		dws_lgn.rememberMe();
		dws_lgn.loginButton();
		System.out.println("Login is successfull");
	}
	
//	@AfterMethod   
//	public void logout() {
//		DwsLogin dws_lgn=new DwsLogin(driver);
//		dws_lgn.logOut();
//		System.out.println("Logout is successfull");
//	}
	
//	@AfterClass
//	public void postCondition() {
//		driver.quit();
//	}
}
