package steps;

import io.cucumber.java.en.*;

public class Ebay_advenced_search_steps {

	@Given("i am on advanced search page")
	public void i_am_on_advanced_search_page() {
		System.out.println("i am on advanced search page");
	}

	@When("i click on ebay logo")
	public void i_click_on_ebay_logo() {
		System.out.println("i click on ebay logo");
	}

	@Then("i am redirected to home page")
	public void i_am_redirected_to_home_page() {
		System.out.println("i am redirected to home page");
	}

}
