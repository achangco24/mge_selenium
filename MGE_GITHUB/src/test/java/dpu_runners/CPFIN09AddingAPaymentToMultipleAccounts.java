package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN09AddingAPaymentToMultipleAccounts.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN09AddingAPaymentToMultipleAccounts extends AbstractTestNGCucumberTests{

}
