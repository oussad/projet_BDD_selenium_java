package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
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
	
	@When("i advanced search an item")
	public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
		driver.findElement(By.id("_nkw")).sendKeys(dataTable.cell(1, 0));
		driver.findElement(By.id("_ex_kw")).sendKeys(dataTable.cell(1, 1));
		driver.findElement(By.name("_udlo")).sendKeys(dataTable.cell(1, 2));
		driver.findElement(By.name("_udhi")).sendKeys(dataTable.cell(1, 3));
		driver.findElement(By.xpath("//div[@class='adv-form__actions']/button")).click();
		Thread.sleep(5);
	}



}
