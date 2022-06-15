package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dresses {
	
public WebDriver driver;
	
	public Dresses(WebDriver driver) {
		this.driver=driver;
		}
	
	public String dressFinalPriceTag =  "//div[@class='right-block']//child::span[@itemprop='price']";
	public String addToCartButton = "//div[@class='right-block']//child::span[@itemprop='price']//following::span[text()='Add to cart']";

	public String getDressFinalPriceTag() {
		return dressFinalPriceTag;
	}

	public void setDressFinalPriceTag(String dressFinalPriceTag) {
		this.dressFinalPriceTag = dressFinalPriceTag;
	}

	public String getAddToCartButton() {
		return addToCartButton;
	}

	public void setAddToCartButton(String addToCartButton) {
		this.addToCartButton = addToCartButton;
	}
	
	
	/*
	 * public List<WebElement> getFinalPriceOfDresses() { return
	 * driver.findElements(dressFinalPriceTag); }
	 */
	

	
	

}
