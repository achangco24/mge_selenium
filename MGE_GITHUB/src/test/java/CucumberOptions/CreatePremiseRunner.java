package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/CreatePremise.feature",
		glue= "Premise")
public class CreatePremiseRunner extends AbstractTestNGCucumberTests {

}
