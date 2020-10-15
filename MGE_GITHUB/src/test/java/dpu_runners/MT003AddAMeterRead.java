/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * MT003 Add a Meter Read
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-17	GSando	Initial version.                
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/MT003AddAMeterRead.feature", 
		glue = "dpu_stepdefinitions"
		)
public class MT003AddAMeterRead extends AbstractTestNGCucumberTests{

}
