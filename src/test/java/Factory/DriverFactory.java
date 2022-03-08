package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	
	public WebDriver init_Driver(String browserName) {
		
		if(browserName.equals("firefox"))
		{
			WebDriverManager.chromedriver().setup();
		
			tlDriver.set(new ChromeDriver());
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
	
		else
		{
			System.out.println("Please give valid browser");
		}
		
		driver=getDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}
	
	
	public static  WebDriver getDriver() {

		return tlDriver.get();
		
	}
	
	
	
	
	
	
	
	
	
	
}
