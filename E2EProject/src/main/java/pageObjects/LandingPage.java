package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		}
	
	//By dresses = By.xpath("(//div[@id='block_top_menu']//following::a[text()='Dresses'])[1]");
	By dresses = By.xpath("(//a[text()='Dresses'])[2]");
	
	public WebElement getDresses()
	{
		return driver.findElement(dresses);
	}
	
	
}
