package Academy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Dresses;
import pageObjects.LandingPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver=initializeDriver();
	}
	
	
	@Test
	public void addHighestPriceDressIncart() throws IOException
	{
		
		LandingPage land = new LandingPage(driver);
		Dresses dressPage = new Dresses(driver);

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		land.getDresses().click();
		
		String dressPageTitle = driver.getTitle();
		
		String price = null;
		double largestPrice = 0;
		
		
		if(dressPageTitle.equalsIgnoreCase("Dresses - My Store"))
		{
			List<WebElement> dresses = driver.findElements(By.xpath(dressPage.getDressFinalPriceTag()));
			int size = dresses.size();
			double tempprice = 0;
			int pos = 0;
			
			if(size>0)
			{
				
				for(int i=0;i<size;i++)
				{
					WebElement dress = dresses.get(i);
					price = dress.getText().substring(1);
					largestPrice = Double.parseDouble (price);
					
					if(largestPrice > tempprice)
						{tempprice = largestPrice;
						pos = i;}
				}
				//System.out.println("largest price is with " + pos + " " + tempprice);
			}
			
			//scroll to dresses
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("window.scrollBy(0,900)");
			
			//Action class for mouse hover
			Actions a = new Actions(driver);
			a.moveToElement(dresses.get(pos)).build().perform();
			
			//Click Add to Cart
			List<WebElement> addToCart = driver.findElements(By.xpath(dressPage.getAddToCartButton()));
			addToCart.get(pos).click();
			
			//At this point highest price item was added to cart.
			
		}
		
	}

	@AfterTest
	public void teardown()
	{
		//Commenting so that you can see item was added into cart
		//driver.close();
	}
}
