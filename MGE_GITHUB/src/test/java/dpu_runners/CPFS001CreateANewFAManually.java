package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFS001CreateANewFAManually.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFS001CreateANewFAManually extends AbstractTestNGCucumberTests{

}
