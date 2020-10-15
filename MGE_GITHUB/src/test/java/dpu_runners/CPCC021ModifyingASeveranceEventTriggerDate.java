package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCC021ModifyingASeveranceEventTriggerDate.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCC021ModifyingASeveranceEventTriggerDate extends AbstractTestNGCucumberTests{

}
