package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public  WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{

		prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\tools\\E2EProject\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://tools//chromedriver.exe");
			driver= new ChromeDriver();
			//execute in chrome driver

		}
		else if (browserName.equals("firefox"))
		{
			//firefox code
		}
		else if (browserName.equals("IE"))
		{
			//	IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
