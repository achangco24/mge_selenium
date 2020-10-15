/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * MT003 Add Meter Read
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.                
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/MT003AddMeterRead.feature", 
		glue = "dpu_stepdefinitions"
		)
public class MT003AddMeterRead extends AbstractTestNGCucumberTests{

}
