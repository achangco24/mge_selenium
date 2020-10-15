package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN10CancellingAPaymentEvent.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN10CancellingAPaymentEvent extends AbstractTestNGCucumberTests{

}
