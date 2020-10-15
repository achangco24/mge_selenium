package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN02CancelingAnAdjustment.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN02CancelingAnAdjustment extends AbstractTestNGCucumberTests{

}
