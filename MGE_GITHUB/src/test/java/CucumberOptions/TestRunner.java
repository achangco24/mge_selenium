package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/PracticeTest.feature",
		glue= "Test")
public class TestRunner extends AbstractTestNGCucumberTests {

}
