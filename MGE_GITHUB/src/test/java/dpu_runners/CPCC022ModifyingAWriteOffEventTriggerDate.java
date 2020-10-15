package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCC022ModifyingAWriteOffEventTriggerDate.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCC022ModifyingAWriteOffEventTriggerDate extends AbstractTestNGCucumberTests{

}
