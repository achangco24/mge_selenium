package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCC013CancelingASeveranceProcess.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCC013CancelingASeveranceProcess extends AbstractTestNGCucumberTests{

}
