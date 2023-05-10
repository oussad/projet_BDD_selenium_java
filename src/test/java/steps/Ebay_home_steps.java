package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ebay_home_steps {
	// WebDriver driver= new ChromeDriver();
	WebDriver driver;

	public Ebay_home_steps(Comuns_steps cs) {
		this.driver = cs.get_driver();
	}

	@Given("i am on ebay home page")
	public void navigatetoebayhome() {

		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ebay.com/");

	}

	@When("i click on advanced link")
	public void clicklink() {
		driver.findElement(By.id("gh-as-a")).click();

	}

	@Then("i navigate to advanced search page")
	public void navigateadvancedsearch() {
		String expecteduRL = "https://www.ebay.com/sch/ebayadvsearch";
		String expectedtitle = "Advanced Search | eBay";
		String actuelURL = driver.getCurrentUrl();
		String actueltitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actueltitle);
		Assert.assertEquals(expecteduRL, actuelURL);

	}

	@When("i search {string}")
	public void i_search_selenium_webdriver(String item) {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(item);
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

	}

	@Then("i validate at least {int} search items present")
	public void i_validate_at_least_search_items_present(int nombre) {
		String nombre_item = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/span[1]"))
				.getText();
		int nombre_item_int = Integer.parseInt(nombre_item);
		if (nombre_item_int < nombre) {
			fail("nombres d element affiche <" + nombre);

		}

	}

	@When("i search {string} in {string} category")
	public void i_search_in_category(String item, String category) {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(item);
		List<WebElement> category_recupere = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		for (WebElement element : category_recupere) {
			if (element.getText().toUpperCase().equals(category.toUpperCase())) {
				element.click();
				break;
			}
			
		}
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		
		
		
	}
	

	@When("i click on {string}")
	public void i_click_on(String lien) throws InterruptedException {
		driver.findElement(By.linkText(lien)).click();
		Thread.sleep(2000);
	   
	}
	@Then("i validet i navigate to {string} and title contains {string}")
	public void i_validet_i_navigate_to_and_title_contains(String url, String titre) {
		String actuel_url= driver.getCurrentUrl();
		String actuel_title= driver.getTitle();
		if (!actuel_url.equals(url)) {
			fail("le lien ne redirege pas vers la bonne page");
		}
		if (!actuel_title.contains(titre)) {
			fail("les titres sont differents ");
		}
	}



}
