package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/SEC001CheckPremiseCWDCISDivision.feature", 
		glue = "dpu_stepdefinitions"
		)
public class SEC001CheckPremiseCWDCISDivision extends AbstractTestNGCucumberTests{

}
