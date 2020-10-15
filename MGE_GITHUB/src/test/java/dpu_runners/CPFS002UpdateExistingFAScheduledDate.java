package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFS002UpdateExistingFAScheduledDate.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFS002UpdateExistingFAScheduledDate extends AbstractTestNGCucumberTests{

}
