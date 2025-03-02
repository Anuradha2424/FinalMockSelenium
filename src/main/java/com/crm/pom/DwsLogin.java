package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsLogin {
	
	public DwsLogin(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
@FindBy(className = "ico-login")
private WebElement login_link;
@FindBy(id = "Email")
private WebElement username;
@FindBy(name = "Password")
private WebElement password;
@FindBy(css="#RememberMe")
private WebElement rememberMe;
@FindBy(xpath = "//input[@value='Log in']")
private WebElement login_button;
@FindBy(className="ico-logout")
private WebElement logOut;

public void loginLink() {
	login_link.click();
}
public void userName(String email){
	username.sendKeys(email);
}
public void password(String pass) {
	password.sendKeys(pass);
}
public void rememberMe() {
	rememberMe.click();
}
public void loginButton() {
	login_button.click();
}
public void logOut() {
	logOut.click();
}
}
