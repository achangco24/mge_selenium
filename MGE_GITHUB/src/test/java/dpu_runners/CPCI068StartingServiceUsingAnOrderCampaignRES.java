package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCI068StartingServiceUsingAnOrderCampaignRES.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCI068StartingServiceUsingAnOrderCampaignRES extends AbstractTestNGCucumberTests{

}
