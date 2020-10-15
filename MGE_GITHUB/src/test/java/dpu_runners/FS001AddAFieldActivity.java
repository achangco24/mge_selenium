/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * FS001 Add a Field Activity
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-20	GSando	Initial version.                
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/FS001AddAFieldActivity.feature", 
		glue = "dpu_stepdefinitions"
		)
public class FS001AddAFieldActivity extends AbstractTestNGCucumberTests{

}
