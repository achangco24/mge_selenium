/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * CPCI022 Creating a Deposit SA
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-17	RExtra	CP_CI.022	Add components for Creating a Deposit SA
 * 
 *************************************************************************************
 */
package dpu_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/dpu_features/CPCI022CreatingADepositSA.feature", 
		glue = "dpu_stepdefinitions"
		)
public class CPCI022CreatingADepositSA extends AbstractTestNGCucumberTests{

}
