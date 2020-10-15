package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCC010CancelingACollectionProcess.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCC010CancelingACollectionProcess extends AbstractTestNGCucumberTests{

}
