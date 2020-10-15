package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCI069StartingServiceUsingAnOrderCampaignCOM.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCI069StartingServiceUsingAnOrderCampaignCOM extends AbstractTestNGCucumberTests{

}
