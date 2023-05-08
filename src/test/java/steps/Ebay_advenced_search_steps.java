package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class Ebay_advenced_search_steps {
	WebDriver driver;

	public Ebay_advenced_search_steps(Comuns_steps cs) {
		this.driver = cs.get_driver();
	}
	@Given("i am on advanced search page")
	public void i_am_on_advanced_search_page() {
		driver.get("https://www.ebay.com/sch/ebayadvsearch");
	}

	@When("i click on ebay logo")
	public void i_click_on_ebay_logo() {
		driver.findElement(By.id("gh-la")).click();
	}

	@Then("i am redirected to home page")
	public void i_am_redirected_to_home_page() {
		String expecteduRL = "https://www.ebay.com/";
		String expectedtitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String actuelURL = driver.getCurrentUrl();
		String actueltitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actueltitle);
		Assert.assertEquals(expecteduRL, actuelURL);
	}

}
