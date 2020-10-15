package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPBI006CancelingABillSegment.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPBI006CancelingABillSegment extends AbstractTestNGCucumberTests{

}
