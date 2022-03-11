package Hooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
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

	private DriverFactory dobj = new DriverFactory();
	private WebDriver driver;
	private ConfigReader cobj = new ConfigReader();
	Properties prop;

	@Before(order = 0)
	public void getProperty() throws IOException {
		prop = cobj.init_prop();

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@Before(order = 1)
	public void detDriverByPageFactory() {
		String bName = prop.getProperty("browser");
		driver = dobj.init_Driver(bName);

	}

	@After(order = 1)
	public void tearDwon(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {

			String s = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(bytes, "image/png", s);

		}
	}

}
