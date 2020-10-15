package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCI030AddingAPaymentArrangementRequest.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCI030AddingAPaymentArrangementRequest extends AbstractTestNGCucumberTests{

}
