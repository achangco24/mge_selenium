package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCC002AddingACollectionAgencyReferral.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCC002AddingACollectionAgencyReferral extends AbstractTestNGCucumberTests{

}
