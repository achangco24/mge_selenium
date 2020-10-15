package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN01AddingAnAdjustment.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN01AddingAnAdjustment extends AbstractTestNGCucumberTests{

}
