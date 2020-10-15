/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * TD001 Completing a To Do
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-30	GSando	Initial version.                
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/TD001CompletingAToDo.feature", 
		glue = "dpu_stepdefinitions"
		)

public class TD001CompletingAToDo extends AbstractTestNGCucumberTests {
	
}
