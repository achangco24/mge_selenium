package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN11CancelingAutoPay.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN11CancelingAutoPay extends AbstractTestNGCucumberTests{

}
