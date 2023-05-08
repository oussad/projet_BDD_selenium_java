package steps;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Comuns_steps {
	private WebDriver driver;

	@Before
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			//prendre une capture d ecrn de scenation echoue 
			final byte[] screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//et colle cette capture dasn le rapport de test
			scenario.attach(screen, "image/png",scenario.getName());

		}

		driver.quit();
	}

	public WebDriver get_driver() {

		return driver;
	}
}
