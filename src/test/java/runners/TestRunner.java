package runners;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty",
				"html:Cucumber_reports/cucumber_report.html",
				"json:Cucumber_reports/cucumber_report.lason"},
		features="./src/test/resources/features", //location of the feature files
		glue="tests",//location of step definitions
		tags="@homework"
		)
public class TestRunner {

}