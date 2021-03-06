package POM;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage {

	WebDriver driver;

	private By logo = By.xpath("//img[@class='logo img-responsive']");
	private By width = By.xpath("//img[@class='logo img-responsive']");
	private By listOfItems = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li");
	private By searchBox = By.id("search_query_top");
	private By searchBtn = By.name("submit_search");
	private By searchResult = By.xpath("//div[@class='ac_results']//ul//li");
	private By twitterLink = By.xpath("//li[@class='twitter']");
	private By accountName = By.xpath(
			"//div[@class='css-1dbjc4n r-1awozwy r-xoduu5 r-18u37iz r-dnmrzs']//span[contains(text(),'Selenium Framework')]");

	public FirstPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getLaunch() {

		driver.get("http://automationpractice.com/");
	}

	public String homePageTitle() {

		return driver.getTitle();
	}

	public String getUrlOfPage() {
		return driver.getCurrentUrl();
	}

	public boolean checkLogoVisiblility() {
		boolean b = driver.findElement(logo).isDisplayed();
		return b;
	}

	public void checkWidthHeight(int w, int h) {
		String widthOfLogo = driver.findElement(width).getAttribute("width");
		String heightOfLogo = driver.findElement(width).getAttribute("height");

		int wdt = Integer.valueOf(widthOfLogo);

		int hgt = Integer.valueOf(heightOfLogo);

		if (wdt == 350 && hgt == 99) {
			// System.out.println("application logo width is :"+wdt+" height is :"+hgt);

			Assert.assertTrue(true);

		}

	}

	public int productCategoris() {

		List<WebElement> list = driver.findElements(listOfItems);

		int Count = 0;

		for (int i = 0; i < list.size(); i++) {

			String str = list.get(i).getText();

			if (str.contains("WOMEN") || str.contains("DRESSES") || str.contains("T-SHIRTS")) {

				Count++;
			}

		}

		return Count;

	}

	public List txtOfProductCategoris() {

		List<String> l = new ArrayList();

		List<WebElement> expectedList = driver.findElements(listOfItems);

		String s = null;
		for (int i = 0; i < expectedList.size(); i++) {
			s = expectedList.get(i).getText();
			if (s.contains("WOMEN") || s.contains("DRESSES") || s.contains("T-SHIRTS")) {
				l.add(s);
			}
		}

		return l;

	}

	public void searchItems() throws InterruptedException {
		driver.findElement(searchBox).sendKeys("T-shirt");

	}

	public String searchResultValidation() {

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String txt = driver.findElement(searchResult).getText();

		return txt;

	}

	public void doClick() throws InterruptedException {
		driver.findElement(searchBtn).click();
		Thread.sleep(2000);

	}

	public void linkedToTwitter() {
		driver.findElement(twitterLink).click();
	}

	public String openNewWindow() {
		String txt = "";
		Set<String> s = driver.getWindowHandles();

		for (String windowHandles : s) {
			txt = driver.switchTo().window(windowHandles).getTitle();
		}

		return txt;

	}

	public String AccountName() {

		String actName = driver.findElement(accountName).getText();

		return actName;
	}

}
