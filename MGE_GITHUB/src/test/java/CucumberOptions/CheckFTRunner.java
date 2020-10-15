package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/FinancialTransaction.feature",
		glue= "Financial")

public class CheckFTRunner extends AbstractTestNGCucumberTests {

}
