package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFS009CreateAndCompleteFA.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFS009CreateAndCompleteFA extends AbstractTestNGCucumberTests{

}
