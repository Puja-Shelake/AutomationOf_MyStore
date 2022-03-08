package POM;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FirstPage {

	WebDriver driver;

	private By logo = By.xpath("//img[@class='logo img-responsive']");
	private By width = By.xpath("//img[@class='logo img-responsive']");
	private By listOfItems = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li");
	private By searchBox = By.id("search_query_top");
	private By searchBtn = By.name("submit_search");
	private By searchResult = By.xpath("//div[@class='ac_results']//ul//li");
	private By twitterLink = By.xpath("//li[@class='twitter']");
	private By accountName = By.xpath("//span[contains(@class,'css-901oao ') and text()='Selenium Framework']");

	public FirstPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getRedirection() {
		driver.get("http://automationpractice.com/");
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

		int wdt=Integer.valueOf(widthOfLogo);
		
		
		int hgt=Integer.valueOf(heightOfLogo);
		
		if(wdt==w && hgt==h)
		{
			System.out.println("application logo width is :"+wdt+" height is :"+hgt);
		}

	}

	public void productCategoris() {
		List<WebElement> list = driver.findElements(listOfItems);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getText() + "  ");

		}
		System.out.println();
	}

	public void searchItems() throws InterruptedException {
		driver.findElement(searchBox).sendKeys("T-shirt");
		Thread.sleep(3000);
	}

	public String searchResultValidation() {

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
