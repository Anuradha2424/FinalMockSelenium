package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAddPage {

	public ProductAddPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath="//span[@class='cart-label']")
	private WebElement cart_label;

	public void cartLabel() {
		cart_label.click();
	}
	
	@FindBy(xpath="//td[@class='subtotal nobr end']/span[2]")
	private WebElement prices;

	public List<WebElement> prices() {
		return (List<WebElement>) prices;
	}
	
	@FindBy(xpath="//td[@class='remove-from-cart']")
	private WebElement remove_btn;
    
	public List<WebElement> removeBtn() {
		return (List<WebElement>) remove_btn;
	}
	
	@FindBy(xpath="//input[@name='updatecart']")
	private WebElement update_cart;

	public void updateCart() {
		update_cart.click();
	}
	
}
