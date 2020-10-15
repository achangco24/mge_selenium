package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/WarmUp.feature",
		glue= "WarmUp")
public class WarmUp extends AbstractTestNGCucumberTests {

}
