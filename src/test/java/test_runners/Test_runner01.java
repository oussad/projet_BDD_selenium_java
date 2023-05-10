package test_runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "features" }, 
        glue = { "steps" },
        //tags = "@t6",
        //name = {"link"},
        monochrome = true, 
       // plugin = { "pretty","html:Rapport1.html" },
		// plugin = { "pretty", "json:Rapport2.json" },
        plugin = { "pretty","json:target/json-report/cucumber.json" },

		dryRun = false

)
public class Test_runner01 {

}
