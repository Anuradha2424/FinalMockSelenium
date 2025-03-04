package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownload {
	public DigitalDownload(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(linkText="Digital downloads")
	private WebElement DigitalDLink;
	
	public void DigiDLink() {
		DigitalDLink.click();
	}
	
	@FindBy(xpath="//span[@class='cart-label']")
	private WebElement Addcart;
	
	public void addCart() {
		Addcart.click();
	}
	
	@FindBy(xpath="//input[@name='updatecart']")
	private WebElement Updatecart;
	
	public void updateCart() {
		Updatecart.click();
	}
}
