package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

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
		String expectedtitle = "Advanced Search | eBaya";
		String actuelURL = driver.getCurrentUrl();
		String actueltitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actueltitle);
		Assert.assertEquals(expecteduRL, actuelURL);

	}

}
