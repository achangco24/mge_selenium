package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFS003CancelExistingFA.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFS003CancelExistingFA extends AbstractTestNGCucumberTests{

}
