package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCC015CancelingAWriteOffProcess.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCC015CancelingAWriteOffProcess extends AbstractTestNGCucumberTests{

}
