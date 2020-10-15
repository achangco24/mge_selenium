/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * CI022 Add a Log Entry to a Customer Contact
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-16	GSando	Initial version.                
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CI022AddALogEntryToACustomerContact.feature", 
		glue = "dpu_stepdefinitions"
		)

public class CI022AddALogEntryToACustomerContact extends AbstractTestNGCucumberTests {

}
