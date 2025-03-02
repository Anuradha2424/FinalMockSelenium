package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FollowUs {

	public FollowUs(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	@FindBy(xpath ="//div[@class='column follow-us']/ul/li/a")
	private WebElement followus;
	@FindBy(className="css-1jxf684 r-bcqeeo r-1ttztb7 r-qvutc0 r-poiln3")
	private WebElement createact;
	@FindBy(xpath="//input[@name='name']")
	private WebElement name;
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	@FindBy(id="SELECTOR_1")
	private WebElement month;
	@FindBy(id="SELECTOR_2")
	private WebElement day;
	@FindBy(id="SELECTOR_3")
	private WebElement year;

	
	public void createAct() {
		createact.click();
	}
	public List<WebElement> followUs() {
		return (List<WebElement>) followus;
	}
	public void name(String dataname) {
		name.sendKeys(dataname);
	}
	public void email(String dataemail) {
		email.sendKeys(dataemail);
	}
	public WebElement month()
	{
		return month;
	}
	public WebElement year()
	{
		return year;
	}
	public WebElement day()
	{
		return day;
	}
}
