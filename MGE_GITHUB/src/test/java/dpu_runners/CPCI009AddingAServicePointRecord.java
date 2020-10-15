package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "src/test/java/dpu_features/CPCI009AddingAServicePointRecord.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCI009AddingAServicePointRecord extends AbstractTestNGCucumberTests{

}
