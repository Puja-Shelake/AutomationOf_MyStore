package Hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Base {

	private DriverFactory dobj=new DriverFactory();
	private WebDriver driver;
	private ConfigReader cobj=new ConfigReader();
	Properties prop;

	@Before(order = 0)
	public void getProperty() throws IOException {
		prop=cobj.init_prop(); 
		String bName=prop.getProperty("browser");
		driver=dobj.init_Driver(bName);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
