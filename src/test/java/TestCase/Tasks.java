package TestCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.BaseClass.DWSBase;
import com.crm.FileUtility.ReadFromProperties1;
import com.crm.pom.DigitalDownload;
import com.crm.pom.FollowUs;
import com.crm.pom.ProductAddPage;

public class Tasks extends DWSBase {
	@Test
	public void testCase1() throws InterruptedException {
	
	 //verify the page by using url
	 String expected_url="https://demowebshop.tricentis.com/";
	 String actual_url=driver.getCurrentUrl();
	 //click the all links
	 if(expected_url.equals(actual_url)) {
	 Reporter.log("i am in dws",true);
	 List<WebElement> followUS=driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
	 for (WebElement web : followUS) {
		    web.click();
			String expected_url1="https://x.com/nopCommerce";
			String actual_url1=driver.getCurrentUrl();
			if(expected_url1.equals(actual_url1)) {
			 FollowUs links=new FollowUs(driver);
			 links.createAct();
			 links.email("anuradhaneware@gmail.com");
			 links.name("Anuradha");	
			 Select sel=new Select(links.month());
			 sel.selectByIndex(0);
			 Select sel2=new Select(links.day());
			 sel2.selectByIndex(0);
		     Select sel3=new Select(links.year());
			 sel3.selectByIndex(0);	
			 Reporter.log("I am in twitter url and account created successfully",true);
			 driver.navigate().back(); 
			}
			String expected_url_rss="https://demowebshop.tricentis.com/news/rss/1";
			String actual_url_rss=driver.getCurrentUrl();			   
		    if(expected_url_rss.equals(actual_url_rss)) {
				   Reporter.log("I am in rss url",true);
				   driver.navigate().back(); 
		      }
			}
	 }		
	}
	
	@Test
	public void testCase2() throws InterruptedException, IOException {
		String name=ReadFromProperties1.getData("recipient-name");
		String email=ReadFromProperties1.getData("recipient-email");
		//click gift cart
		DigitalDownload digi=new DigitalDownload(driver);
		digi.giftCart();
		//add all product which is present in gift cart
		List<WebElement> gift_carts =driver.findElements(By.xpath("//div[@class='add-info']/div[2]/input"));
		for (WebElement web : gift_carts) {
			web.click();
			Thread.sleep(2000);
			
			 String virtual_cart="https://demowebshop.tricentis.com/5-virtual-gift-card";
			 String virtual_cart1="https://demowebshop.tricentis.com/25-virtual-gift-card";			
			 String actual_carts=driver.getCurrentUrl();
			  if(virtual_cart.equals(actual_carts) || virtual_cart1.equals(actual_carts))
			 {
			    digi.recipientname(name);
			    digi.recipientemail(email);
			    digi.addToCart();
			 }
			  else{
				  digi.recipientname(name);
				  digi.addToCart();
			  }
		   
            driver.navigate().back();	
		}
		Reporter.log("All product added successfully in shopping cart");
		ProductAddPage pap=new ProductAddPage(driver);
		pap.cartLabel();
		List<WebElement> prices =driver.findElements(By.xpath("//td[@class='subtotal nobr end']/span[2]"));
		List<WebElement> removeButton=driver.findElements(By.xpath("//td[@class='remove-from-cart']"));
		
		double highestPrice = 0.0;
        int highestPriceIndex = -1;

        // Identify the highest price and its index
        for (int i = 0; i < prices.size(); i++) {
            double price = Double.parseDouble(prices.get(i).getText());
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceIndex = i;
              }
        }
        
        // Remove the product with the highest price
        if (highestPriceIndex != -1) {
            removeButton.get(highestPriceIndex).click();
            System.out.println("Removed the highest-priced product with price: " + highestPrice);
            pap.updateCart();
        } else {
            System.out.println("No products found in the cart to remove.");
        }

	}
	
	}


