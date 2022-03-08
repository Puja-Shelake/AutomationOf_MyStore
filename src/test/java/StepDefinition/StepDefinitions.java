package StepDefinition;

import org.junit.Assert;

import Factory.DriverFactory;
import POM.FirstPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	String BaseURL = "http://automationpractice.com";
	String actualRedirection = "http://automationpractice.com/index.php";

	FirstPage fobj = new FirstPage(DriverFactory.getDriver());

	@Given("Application URL redirection Redirected to {string}")
	public void application_url_redirection_redirected_to(String url) {
		fobj.getRedirection();
		String currentUrl = fobj.getUrlOfPage();
		Assert.assertEquals("Getting Wrong URL", currentUrl, url);
	}

	@When("Application logo visibility")
	public void application_logo_visibility() {
		boolean b = fobj.checkLogoVisiblility();
		Assert.assertTrue(b);
	}

	@When("Application logo width is {int} & height is {int}")
	public void application_logo_width_is_height_is(Integer width, Integer height) {
		fobj.checkWidthHeight(width, height);
	}

	@When("Application product main category list validation")
	public void application_product_main_category_list_validation() {
		fobj.productCategoris();
	}

	@Then("Application Search functionality")
	public void application_search_functionality() throws InterruptedException {
		fobj.searchItems();
		String txt = fobj.searchResultValidation();

		if (txt.contains("T-shirt")) {

			fobj.doClick();
		}

	}

	@Then("Application social media handles validation")
	public void application_social_media_handles_validation() {
		fobj.linkedToTwitter();
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		String txt = fobj.openNewWindow();
		if (txt.contains("Selenium Framework")) {
			String accountName=fobj.AccountName();
			
			Assert.assertEquals(accountName, "Selenium Framework");
		}
	}

}
