package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCI031CancelingAPayPlan.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCI031CancelingAPayPlan extends AbstractTestNGCucumberTests{

}
