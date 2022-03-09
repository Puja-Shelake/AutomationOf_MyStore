package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/feature/Assignment.feature"},
		glue = {"StepDefinition","Hooks"},
		monochrome = true,
		tags="@twitter", 
        plugin = {"pretty",
            "html:target/MyReports/report.html",
            "json:target/MyReports/report.json",
            "junit:target/MyReports/report.xml",
            }
        //publish=true
        //dryRun=false 
        )




public class Runner {

}
