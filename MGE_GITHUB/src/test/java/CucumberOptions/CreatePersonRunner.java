package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/CreatePerson.feature",
		glue= "Person")
public class CreatePersonRunner extends AbstractTestNGCucumberTests {

}
