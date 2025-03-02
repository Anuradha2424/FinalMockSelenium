package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownload {
	public DigitalDownload(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(partialLinkText="Gift Cards")
	private WebElement gift_cart;

	public void giftCart() {
		gift_cart.click();
	}
	
	@FindBy(xpath="//div[@class='add-info']/div[2]/input")
	private WebElement gift_carts;

	public List<WebElement> giftCarts() {
		return (List<WebElement>) gift_carts;
	}
	
	@FindBy(className="recipient-name")
	private WebElement recipientName;
	
	public void recipientname(String name) {
		recipientName.sendKeys(name);
	}
	
	@FindBy(className="recipient-name")
	private WebElement recipientEmail;
	
	public void recipientemail(String email) {
		recipientEmail.sendKeys(email);
	}
	
	@FindBy(xpath="//div[@class='add-to-cart']/div/input[2]")
	private WebElement addToCart;

	public void addToCart() {
		addToCart.click();
	}
	
	
}
