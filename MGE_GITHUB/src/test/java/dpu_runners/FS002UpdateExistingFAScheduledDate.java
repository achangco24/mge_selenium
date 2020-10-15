/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * FS002 Update Existing FA Schedule Date
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-21	GSando	Initial version.                
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/FS002UpdateExistingFAScheduledDate.feature", 
		glue = "dpu_stepdefinitions"
		)
public class FS002UpdateExistingFAScheduledDate extends AbstractTestNGCucumberTests{

}