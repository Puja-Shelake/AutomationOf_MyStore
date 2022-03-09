package Hooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Base {

	private DriverFactory dobj=new DriverFactory();
	private WebDriver driver;
	private ConfigReader cobj=new ConfigReader();
	Properties prop;

	@Before
	public void getProperty() throws IOException {
		prop=cobj.init_prop(); 
		String bName=prop.getProperty("browser");
		driver=dobj.init_Driver(bName);
	}

	@After
	public void quitBrowser() {
		driver.quit();
	}
	

	@BeforeStep
	public void s() {
		
	}
	
	@AfterStep
	public void tearDwon(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String ss = scenario.getName().replaceAll(" ", "_");

			TakesScreenshot ts = (TakesScreenshot) driver;

			// byte[] b = ts.getScreenshotAs(OutputType.BYTES);

			File ssInput = ts.getScreenshotAs(OutputType.FILE);

			//name=driverFactory.RandomString();
			
			
			File fs = new File("/home/shelke/Downloads/Mision/CucumberBDDAssignment/Ss"+".jpg");

			FileHandler.copy(ssInput, fs);

			// scenario.attach(b, "image/png", ss);

		}
	}
	
}
