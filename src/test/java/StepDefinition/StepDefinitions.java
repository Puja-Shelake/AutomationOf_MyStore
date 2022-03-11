package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Factory.DriverFactory;
import POM.FirstPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	String BaseURL = "http://automationpractice.com";

	FirstPage fobj = new FirstPage(DriverFactory.getDriver());

	Logger log = Logger.getLogger(StepDefinitions.class);

	@Given("User Launch url")
	public void user_launch_url() {
		PropertyConfigurator.configure("log4j.properties");
		fobj.getLaunch();
		log.info("User launch url");
	}

	@When("User is on home page")
	public void user_is_on_home_page() {
		String tilte = fobj.homePageTitle();
		log.info("User is on home");
		Assert.assertEquals("My Store", tilte);
		log.info("Title of the page is :" + tilte);
	}

	@Then("User gets redirected URL {string}")
	public void user_gets_redirected_url(String url) {

		fobj.getUrlOfPage();
		String currentUrl = fobj.getUrlOfPage();
		Assert.assertEquals("Getting Wrong URL", currentUrl, url);
		log.info("After launching url navigated to  " + url);
	}

	@When("After launching Check logo is displayed or not")
	public void after_launching_check_logo_is_displayed_or_not() {
		boolean b = fobj.checkLogoVisiblility();
		Assert.assertTrue(b);

		log.info(" logo is displyed");
	}

	@Then("Logo  having width is {int} and height is {int}")
	public void logo_having_width_is_and_height_is(Integer width, Integer height) {
		fobj.checkWidthHeight(width, height);

		log.info("Getting width is:" + width + "and" + "height of the attribute is :" + height);
	}

	@Then("After Launching categories of the product count is {int}")
	public void after_launching_categories_of_the_product_count_is(Integer c) {
		int count = fobj.productCategoris();

		log.info("Count of the product will displayed on page is :" + count);
	}

	@When("Displayed text the product categoris")
	public void displayed_text_the_product_categoris() {

		List<String> e = new ArrayList<String>();
		e.add("WOMEN");
		e.add("DRESSES");
		e.add("T-SHIRTS");

		List<String> a = fobj.txtOfProductCategoris();

		for (int i = 0; i < a.size(); i++) {
			Assert.assertEquals("", e.get(i), a.get(i));
		}

		log.info("3 text displyed");
	}

	@When("User Enters text “T-shirt”")
	public void user_enters_text_t_shirt() throws InterruptedException {
		fobj.searchItems();
		log.info("Items searched");

	}

	@Then("Search Engine gives suggestion to user with entered text i.e “T-shirt”")
	public void search_engine_gives_suggestion_to_user_with_entered_text_i_e_t_shirt() {
		fobj.searchResultValidation();
		log.info("After entering user can see entered items in Suggetions");
	}

	@When("User Click on twitter link its navigated to new window")
	public void user_click_on_twitter_link_its_navigated_to_new_window() {
		fobj.linkedToTwitter();
		log.info("Clicked on twitter link from footer of the landing page");
	}

	@Then("User gets account name is {string}")
	public void user_gets_account_name_is(String acName) {
		String acname = fobj.AccountName();

		Assert.assertEquals(acName, acname);

		log.info("Account name is Selenium Framework");
	}

}
