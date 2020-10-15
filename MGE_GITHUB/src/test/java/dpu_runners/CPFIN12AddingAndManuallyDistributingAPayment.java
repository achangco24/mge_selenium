package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN12AddingAndManuallyDistributingAPayment.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN12AddingAndManuallyDistributingAPayment extends AbstractTestNGCucumberTests{

}
