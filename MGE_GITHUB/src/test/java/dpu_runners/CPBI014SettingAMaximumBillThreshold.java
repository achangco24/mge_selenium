package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPBI014SettingAMaximumBillThreshold.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPBI014SettingAMaximumBillThreshold extends AbstractTestNGCucumberTests{

}
