package dpu_cp001_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_cp001_features/DPU_C2J007_001.feature", 
		glue = "dpu_cp001_stepdefinitions"
		)
public class DPU_C2J007_001 extends AbstractTestNGCucumberTests {

}
