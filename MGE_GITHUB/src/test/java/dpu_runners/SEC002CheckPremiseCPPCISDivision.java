package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/SEC002CheckPremiseCPPCISDivision.feature", 
		glue = "dpu_stepdefinitions"
		)
public class SEC002CheckPremiseCPPCISDivision extends AbstractTestNGCucumberTests{

}
