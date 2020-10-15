package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPFIN26TransferringOfBalance.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPFIN26TransferringOfBalance extends AbstractTestNGCucumberTests{

}
